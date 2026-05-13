package com.hyper.gui;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.text.Text;

public class ExampleGui extends LightweightGuiDescription {
    public ExampleGui(String author, int authorColor, int backgroundColor) {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(90, 0);

        root.setBackgroundPainter(BackgroundPainter.createColorful(backgroundColor));

        root.setInsets(Insets.ROOT_PANEL);

        // "Written By:" in white
        WLabel labelPrefix = new WLabel(Text.literal("Written By:").styled(s -> s.withBold(true).withColor(0xFFFFFFFF)));
        root.add(labelPrefix, 0, 0, 3, 0);

        // Author's name in yellow
        WLabel labelAuthor = new WLabel(Text.literal(author), authorColor);
        root.add(labelAuthor, 0, 1, 3, 0);

        root.validate(this);
    }
}