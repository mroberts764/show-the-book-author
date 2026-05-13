package com.hyper.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "STBA")
public class STBAConfig implements ConfigData {
    @ConfigEntry.ColorPicker
    public int backgroundColor = 0xFF2E3440;
    @ConfigEntry.ColorPicker
    public int authorColor = 0xFF00FFFF;


}
