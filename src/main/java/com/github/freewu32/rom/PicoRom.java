package com.github.freewu32.rom;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * pico-8游戏镜像
 */
public class PicoRom implements Serializable {
    public static final PicoRom EMPTY = new PicoRom();
    /**
     * 版本号
     */
    private int version;

    /**
     * 脚本
     */
    private String lua;

    /**
     * 精灵表
     */
    private byte[] gfx;

    /**
     * 精灵标志
     */
    private byte[] gff;

    /**
     * 标签
     */
    private byte[] label;

    /**
     * 地图
     */
    private byte[] map;

    /**
     * 音效
     */
    private byte[] sfx;

    /**
     * 音乐模式
     */
    private byte[] music;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getLua() {
        return lua;
    }

    public void setLua(String lua) {
        this.lua = lua;
    }

    public byte[] getGfx() {
        return gfx;
    }

    public void setGfx(byte[] gfx) {
        this.gfx = gfx;
    }

    public byte[] getGff() {
        return gff;
    }

    public void setGff(byte[] gff) {
        this.gff = gff;
    }

    public byte[] getLabel() {
        return label;
    }

    public void setLabel(byte[] label) {
        this.label = label;
    }

    public byte[] getMap() {
        return map;
    }

    public void setMap(byte[] map) {
        this.map = map;
    }

    public byte[] getSfx() {
        return sfx;
    }

    public void setSfx(byte[] sfx) {
        this.sfx = sfx;
    }

    public byte[] getMusic() {
        return music;
    }

    public void setMusic(byte[] music) {
        this.music = music;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PicoRom rom = (PicoRom) o;
        return version == rom.version &&
                Objects.equals(lua, rom.lua) &&
                Arrays.equals(gfx, rom.gfx) &&
                Arrays.equals(gff, rom.gff) &&
                Arrays.equals(label, rom.label) &&
                Arrays.equals(map, rom.map) &&
                Arrays.equals(sfx, rom.sfx) &&
                Arrays.equals(music, rom.music);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(version, lua);
        result = 31 * result + Arrays.hashCode(gfx);
        result = 31 * result + Arrays.hashCode(gff);
        result = 31 * result + Arrays.hashCode(label);
        result = 31 * result + Arrays.hashCode(map);
        result = 31 * result + Arrays.hashCode(sfx);
        result = 31 * result + Arrays.hashCode(music);
        return result;
    }
}
