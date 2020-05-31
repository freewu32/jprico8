package com.github.freewu32;

import com.github.freewu32.rom.PicoRom;
import com.github.freewu32.rom.PngRomLoader;
import com.github.freewu32.rom.RomLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class PngRomLoaderTest {

    @Test
    public void testLoad() throws Exception {
        RomLoader loader = new PngRomLoader();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(
                "rom/jelpi.p8.png")) {
            PicoRom rom = loader.load(is);
            Assertions.assertEquals(rom.getVersion(), 0);
            Assertions.assertEquals(rom.getLua().length(),10896);
            System.out.println(rom.getLua());
        }
    }
}