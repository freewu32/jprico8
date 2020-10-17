package com.github.freewu32.game;

import com.github.freewu32.graph.GraphLib;
import com.github.freewu32.music.MusicLib;
import com.github.freewu32.rom.PicoRom;
import com.github.freewu32.rom.PngRomLoader;
import com.github.freewu32.rom.RomLoader;
import javafx.scene.canvas.Canvas;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LoadState;
import org.luaj.vm2.ast.Str;
import org.luaj.vm2.compiler.LuaC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 游戏执行逻辑
 */
public class PicoGame {

    private Globals luaVm;

    private Canvas canvas;

    private RomLoader romLoader;

    public PicoGame(Canvas canvas) {
        this.canvas = canvas;
        luaVm = new Globals();
        luaVm.load(new GraphLib(this.canvas));
        luaVm.load(new MusicLib());
        LoadState.install(luaVm);
        LuaC.install(luaVm);
        this.romLoader = new PngRomLoader();
    }

    public void loadForPath(String path) {
        try {
            PicoRom rom = this.romLoader.load(Files.newInputStream(Paths.get(path)));
            this.loadRom(rom);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载游戏rom
     */
    private void loadRom(PicoRom rom) {
        luaVm.load(rom.getLua()).call();
    }
}
