package com.github.freewu32.music;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.ThreeArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;

public class MusicLib extends TwoArgFunction {

    private final LuaValue music = new ThreeArgFunction() {

        @Override
        public LuaValue call(LuaValue arg1, LuaValue arg2, LuaValue arg3) {
            return arg1;
        }
    };

    @Override
    public LuaValue call(LuaValue modname, LuaValue env) {
        env.set("music", this.music);
        return env;
    }
}
