package com.github.freewu32.rom;

import java.io.InputStream;

/**
 * 游戏镜像加载器接口
 */
public interface RomLoader {

    /**
     * 加载游戏镜像
     * @param is 文件流
     */
    PicoRom load(InputStream is);
}
