package com.github.freewu32.rom;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * png图片格式的rom加载器
 */
public class PngRomLoader implements RomLoader {
    @Override
    public PicoRom load(InputStream is) {
        ByteBuf buffer = getBufferByIs(is);
        try {
            PicoRom rom = new PicoRom();
            rom.setGfx(buffer.slice(0, 0x2000).array());
            rom.setMap(buffer.slice(0x2000, 0x3000).array());
            rom.setGff(buffer.slice(0x3000, 0x3100).array());
            rom.setMusic(buffer.slice(0x3100, 0x3200).array());
            rom.setSfx(buffer.slice(0x3200, 0x4300).array());
            rom.setLua(decodeLua(buffer.copy(0x4300, 0x8000 - 0x4300),
                    rom.getVersion()));
            rom.setVersion(decodeVersion(buffer));
            return rom;
        } finally {
            buffer.release();
        }
    }

    /**
     * 输入流转字节缓冲区
     */
    private ByteBuf getBufferByIs(InputStream is) {
        try {
            BufferedImage image = ImageIO.read(is);

            Raster imageData = image.getData();
            byte[] picoData = new byte[(image.getHeight() * image.getWidth())];

            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    int index = (y * image.getWidth()) + x;

                    int[] color = new int[4];
                    imageData.getPixel(x, y, color);

                    picoData[index] |= ((byte) color[2] & 3);
                    picoData[index] |= ((byte) color[1] & 3) << 2;
                    picoData[index] |= ((byte) color[0] & 3) << 4;
                    picoData[index] |= ((byte) color[3] & 3) << 6;
                }
            }

            return Unpooled.wrappedBuffer(picoData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解析lua脚本
     * 0x4300 - 0x8000
     */
    private String decodeLua(ByteBuf buffer, int version) {
        String header = buffer.toString(0, 4, StandardCharsets.US_ASCII);

        String code = "";

        if (version == 0 || header.equals(":c:0")) {
            int length = 0;

            try {
                length = buffer.bytesBefore((byte) 0);
            } catch (Exception e) {
                length = 0x8000 - 0x4300;
            }

            code = buffer.toString(0, length, StandardCharsets.UTF_8) + "\n";
        } else {
            code = decompressCode(buffer.array());
        }

        code = code.replace('\r', ' ');

        return code;
    }

    /**
     * 解压代码
     */
    private String decompressCode(byte[] codeData) {
        return "";
    }

    /**
     * 解析版本号
     * 0x8000
     */
    private int decodeVersion(ByteBuf buffer) {
        return buffer.getByte(0x8000);
    }
}
