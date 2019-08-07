package com.github.ryancwilliams.mcReliquaryPotionCalc.model.potions

import com.github.ryancwilliams.mcReliquaryPotionCalc.model.items.Item
import kotlin.test.Test
import kotlin.test.asserter

/**
 * Tests the Potion Ingredient Registry
 */
internal class PotionIngredientRegistryTest {

    private val mockAItem = Item("Item A");
    private val mockAEffects = setOf(PotionEffect(Effect.STRENGTH), PotionEffect(Effect.HASTE))
    private val mockA = PotionIngredient(mockAItem, mockAEffects)

    private val mockBItem = Item("Item B");
    private val mockBEffects = setOf(PotionEffect(Effect.WEAKNESS), PotionEffect(Effect.HASTE))
    private val mockB = PotionIngredient(mockAItem, mockAEffects)

    private val mockCItem = Item("Item C");
    private val mockCEffects = setOf(PotionEffect(Effect.STRENGTH), PotionEffect(Effect.REGENERATION))
    private val mockC = PotionIngredient(mockAItem, mockAEffects)

    /**
     * Populates the registry with the mock items.
     */
    private fun populateRegistry() {
        PotionIngredientRegistry.addToRegistry(mockA)
        PotionIngredientRegistry.addToRegistry(mockB)
        PotionIngredientRegistry.addToRegistry(mockC)
    }

    @Test
    fun `Accessing invalid ingredient registry returns null`() {
        var item = PotionIngredientRegistry.getIngredientByItem(Item("Item"))
        asserter.assertNull("Item should be null", item)
    }

    @Test
    fun `Accessing valid ingredient by item returns the ingredient`() {
        //Add test item
        PotionIngredientRegistry.addToRegistry(mockA)

        //Get the item'
        var item = PotionIngredientRegistry.getIngredientByItem(mockAItem)

        //Check if not null
        asserter.assertNotNull("Item should not be null", item)

        //check if the same item
        asserter.assertEquals("Item should be the same", mockA, item)

    }

}