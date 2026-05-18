package com.hyper.mixin.client;

import com.hyper.config.STBAConfig;
import com.hyper.data.BookAuthorHolder;
import com.hyper.data.BookDataHolder;
import com.hyper.gui.ExampleGui;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.BookScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BookScreen.class)
public abstract class BookScreenMixin {

    @Unique
    private ExampleGui gui;

    @Inject(method = "init", at = @At("TAIL"))
    private void initGui(CallbackInfo ci) {

        BookAuthorHolder holder = (BookAuthorHolder) this;

        if (holder.stba$getAuthor() == null) {
            holder.stba$setAuthor(BookDataHolder.pendingAuthor);
        }

        BookDataHolder.pendingAuthor = null;

        String author = holder.stba$getAuthor();

        if (author == null) return;

        STBAConfig config = AutoConfig
                .getConfigHolder(STBAConfig.class)
                .getConfig();

        int bgColor = 0xFF000000 | config.backgroundColor;
        int authColor = 0xFF000000 | config.authorColor;

        gui = new ExampleGui(author, authColor, bgColor);

        gui.getRootPanel().validate(gui);
    }

    @Inject(method = "render", at = @At("TAIL"))
    private void renderAuthor(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {

        if (gui == null) return;

        int x = 10;
        int y = 10;

        context.getMatrices().pushMatrix();
        context.getMatrices().translate(x, y);

        gui.getRootPanel().paint(context, 0, 0, mouseX, mouseY);

        context.getMatrices().popMatrix();

        if (((BookAuthorHolder)this).stba$getAuthor() != null
                && BookDataHolder.pendingAuthor != null) {
            BookDataHolder.pendingAuthor = null;
        }
    }
}
