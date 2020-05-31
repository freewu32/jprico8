package com.github.freewu32;

import com.github.freewu32.game.PicoGame;
import com.github.freewu32.rom.PicoRom;
import com.github.freewu32.rom.PngRomLoader;
import com.github.freewu32.rom.RomLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.InputStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PicoGameTest {

    private PicoRom rom;

    @BeforeAll
    public void init() throws Exception {
        RomLoader loader = new PngRomLoader();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(
                "rom/jelpi.p8.png")) {
            this.rom = loader.load(is);
        }
    }

    @Test
    public void testLoad() throws Exception {
        PicoGame picoGame = new PicoGame();
        picoGame.loadRom(this.rom);
    }
}
