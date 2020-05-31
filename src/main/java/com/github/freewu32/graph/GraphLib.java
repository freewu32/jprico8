package com.github.freewu32.graph;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.LibFunction;
import org.luaj.vm2.lib.TwoArgFunction;

/**
 * 绘图api模块
 */
public class GraphLib extends TwoArgFunction {

    private final LuaValue camera = new TwoArgFunction() {
        @Override
        public LuaValue call(LuaValue arg1, LuaValue arg2) {
            return null;
        }
    };

    private final LuaValue circ = new LibFunction() {
        @Override
        public LuaValue call(LuaValue a, LuaValue b, LuaValue c, LuaValue d) {
            return super.call(a, b, c, d);
        }
    };

    private final LuaValue circFill = new LibFunction() {
        @Override
        public LuaValue call(LuaValue a, LuaValue b, LuaValue c, LuaValue d) {
            return super.call(a, b, c, d);
        }
    } ;

    @Override
    public LuaValue call(LuaValue modname, LuaValue env) {
        env.set("camera", this.camera);
        env.set("circ", this.circ);
        return env;
    }
}
