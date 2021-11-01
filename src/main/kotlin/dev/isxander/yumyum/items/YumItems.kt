package dev.isxander.yumyum.items

import dev.isxander.yumyum.items.impl.*
import io.ejekta.kambrik.registration.KambrikAutoRegistrar
import net.fabricmc.fabric.api.event.player.AttackEntityCallback
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback
import net.minecraft.entity.EntityType
import net.minecraft.entity.passive.GoatEntity
import net.minecraft.loot.LootManager
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.provider.number.*
import net.minecraft.resource.ResourceManager
import net.minecraft.util.Identifier

object YumItems : KambrikAutoRegistrar {
    val GOAT_MEAT = "goat_meat" forItem GoatMeat()
    val COOKED_GOAT_MEAT = "cooked_goat_meat" forItem CookedGoatMeat()

    val BEE_STINGER = "bee_stinger" forItem BeeStinger()

    override fun manualRegister() {
        LootTableLoadingCallback.EVENT.register { resourceManager, manager, id, table, setter ->
            if (EntityType.GOAT.lootTableId.equals(id)) {
                val poolBuilder = FabricLootPoolBuilder.builder()
                    .rolls(UniformLootNumberProvider.create(1f, 2f))
                    .with(ItemEntry.builder(GOAT_MEAT))

                table.pool(poolBuilder)
            }
            if (EntityType.BEE.lootTableId.equals(id)) {
                val poolBuilder = FabricLootPoolBuilder.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .with(ItemEntry.builder(BEE_STINGER).quality(-2))

                table.pool(poolBuilder)
            }
        }
    }
}