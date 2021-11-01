package dev.isxander.yumyum.items.dsl

import net.minecraft.item.FoodComponent

fun food(block: FoodComponent.Builder.() -> Unit): FoodComponent = FoodComponent.Builder().apply(block).build()