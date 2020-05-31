package com.github.freewu32.game;

import com.github.freewu32.graph.GraphLib;
import com.github.freewu32.rom.PicoRom;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LoadState;
import org.luaj.vm2.compiler.LuaC;

/**
 * 游戏执行逻辑
 */
public class PicoGame {

    private Globals luaVm;

    /**
     * 加载游戏rom
     */
    public void loadRom(PicoRom rom) {
        luaVm = new Globals();
        luaVm.load(new GraphLib());
        LoadState.install(luaVm);
        LuaC.install(luaVm);
        luaVm.load(rom.getLua()).call();
    }
}
