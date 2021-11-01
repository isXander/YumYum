package dev.isxander.yumyum.items.impl

import dev.isxander.yumyum.items.dsl.food
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup

class GoatMeat : Item(
    FabricItemSettings().apply {
        group(ItemGroup.FOOD)
        food(food {
            hunger(3)
            meat()
            saturationModifier(0.3f)
        })
    }
)

class CookedGoatMeat : Item(
    FabricItemSettings().apply {
        group(ItemGroup.FOOD)
        food(food {
            hunger(9)
            meat()
            saturationModifier(1f)
        })
    }
)