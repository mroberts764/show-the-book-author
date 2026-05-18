package com.hyper.mixin.client;

import com.hyper.data.BookAuthorHolder;
import net.minecraft.client.gui.screen.ingame.LecternScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.LecternScreenHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LecternScreen.class)
public abstract class LecternScreenMixin {

    @Final
    @Shadow
    private LecternScreenHandler handler;

    @Inject(method = "updatePageProvider", at = @At("TAIL"))
    private void stba$getLecternAuthor(CallbackInfo ci) {

        ItemStack stack = handler.getBookItem();

        var data = stack.get(DataComponentTypes.WRITTEN_BOOK_CONTENT);

        if (data == null) return;

        if (this instanceof BookAuthorHolder holder) {
            holder.stba$setAuthor(data.author());
        }
    }
}