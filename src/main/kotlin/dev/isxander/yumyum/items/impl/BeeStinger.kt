package dev.isxander.yumyum.items.impl

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolMaterial

class BeeStinger : SwordItem(Material, 2, 0.5f, FabricItemSettings().group(ItemGroup.COMBAT)) {
    override fun postHit(stack: ItemStack, target: LivingEntity, attacker: LivingEntity): Boolean {
        target.addStatusEffect(StatusEffectInstance(StatusEffects.POISON, 30, 3))

        return super.postHit(stack, target, attacker)
    }

    object Material : ToolMaterial {
        override fun getDurability() = 20
        override fun getMiningSpeedMultiplier() = 0f
        override fun getAttackDamage() = 0f
        override fun getMiningLevel() = 0
        override fun getEnchantability() = 5
        override fun getRepairIngredient() = null
    }
}