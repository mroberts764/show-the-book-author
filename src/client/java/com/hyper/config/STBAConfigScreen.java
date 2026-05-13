package com.hyper.config;

import me.shedaniel.autoconfig.AutoConfig;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class STBAConfigScreen {

    public static Screen create(Screen parent) {

        STBAConfig config = AutoConfig
                .getConfigHolder(STBAConfig.class)
                .getConfig();

        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.literal("Show The Book Author Settings"));

        builder.setSavingRunnable(() -> {

            AutoConfig
                    .getConfigHolder(STBAConfig.class)
                    .save();
        });

        ConfigCategory general = builder.getOrCreateCategory(
                Text.literal("General")
        );

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        general.addEntry(
                entryBuilder.startColorField(
                                Text.literal("Author Color"),
                                config.authorColor
                        )
                        .setSaveConsumer(newValue -> {
                            config.authorColor = newValue;
                        }).setDefaultValue(0xFFAA00)
                        .build()
        );

        general.addEntry(
                entryBuilder.startColorField(
                                Text.literal("Background Color"),
                                config.backgroundColor
                        )
                        .setSaveConsumer(newValue -> {
                            config.backgroundColor = newValue;
                        }).setDefaultValue(0x2E3440)
                        .build()
        );

        return builder.build();
    }
}