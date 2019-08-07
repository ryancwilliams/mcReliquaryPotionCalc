package com.github.ryancwilliams.mcReliquaryPotionCalc.model.potions

import com.github.ryancwilliams.mcReliquaryPotionCalc.model.items.Item

/**
 * Represents a potion ingredient.
 * @param item The item that is the ingredient.
 * @param effects The effects this ingredient can give to the potion.
 */
data class PotionIngredient ( val item: Item, override val effects: Set<PotionEffect>) : PotionComponent {

}
