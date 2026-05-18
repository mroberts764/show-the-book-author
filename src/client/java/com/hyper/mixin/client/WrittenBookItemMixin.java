package com.hyper.mixin.client;

import com.hyper.data.BookDataHolder;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WrittenBookItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WrittenBookItem.class)
public class WrittenBookItemMixin {

    @Inject(method = "use", at = @At("HEAD"))
    private void stba$onUse(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<ActionResult> cir) {

        ItemStack stack = user.getStackInHand(hand);

        var data = stack.get(DataComponentTypes.WRITTEN_BOOK_CONTENT);

        if (data == null) return;

        BookDataHolder.pendingAuthor = data.author();
    }
}
