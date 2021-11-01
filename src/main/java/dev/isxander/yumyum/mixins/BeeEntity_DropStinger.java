package dev.isxander.yumyum.mixins;

import dev.isxander.yumyum.items.YumItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BeeEntity.class)
public class BeeEntity_DropStinger {
    @Inject(method = "tryAttack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/BeeEntity;setHasStung(Z)V"))
    public void dropStinger(Entity target, CallbackInfoReturnable<Boolean> cir) {
        BeeEntity bee = (BeeEntity) (Object) this;
        Vec3d dropPos = bee.getPos();
        Vec3d velocity = bee.getVelocity().multiply(2);

        ItemStack stack = new ItemStack(YumItems.INSTANCE.getBEE_STINGER());
        stack.setDamage(9);

        bee.world.spawnEntity(
                new ItemEntity(
                        bee.world,
                        dropPos.x, dropPos.y, dropPos.z,
                        stack,
                        velocity.x, velocity.y, velocity.z
                )
        );
    }
}
