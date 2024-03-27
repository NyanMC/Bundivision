package com.chromanyan.bundivision.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BundleContents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BundleContents.class)
public class BundleContentsMixin {

    @Inject(method = "getWeight", at = @At("RETURN"), cancellable = true)
    private static void getWeight(ItemStack itemStack, CallbackInfoReturnable<Integer> cir) {
        if (cir.getReturnValue() < 1) {
            cir.setReturnValue(1);
        }
    }

}
