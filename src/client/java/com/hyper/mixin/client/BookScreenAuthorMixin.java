package com.hyper.mixin.client;

import com.hyper.data.BookAuthorHolder;
import net.minecraft.client.gui.screen.ingame.BookScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(BookScreen.class)
public class BookScreenAuthorMixin implements BookAuthorHolder {

    @Unique
    private String stba$author;

    @Override
    public void stba$setAuthor(String author) {
        this.stba$author = author;
    }

    @Override
    public String stba$getAuthor() {
        return this.stba$author;
    }
}