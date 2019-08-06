package com.github.ryancwilliams.mcReliquaryPotionCalc.model.items

import kotlin.test.Test
import kotlin.test.asserter

/**
 * Tests the Item Registry
 */
class ItemRegistryTest {

    val mockItemAName = "ItemA"
    val mockItemA = Item(mockItemAName)
    val mockItemBName = "ItemB"
    val mockItemB = Item(mockItemBName)
    val mockItemCName = "ItemC"
    val mockItemC = Item(mockItemCName)

    /**
     * Populates the registry with the mock items.
     */
    private fun populateRegistry() {
        //Add the test items
        ItemRegistry.addToRegistry(mockItemA)
        ItemRegistry.addToRegistry(mockItemB)
        ItemRegistry.addToRegistry(mockItemC)
    }

    @Test
    fun `Accessing empty item registry returns null`() {
        var item = ItemRegistry.getItemByName("item")
        asserter.assertNull("Item should be null", item)
    }

    @Test
    fun `Accessing valid item by name returns the item`() {
        //Add the test item
        ItemRegistry.addToRegistry(mockItemA)

        //Get the test item
        var item = ItemRegistry.getItemByName(mockItemAName)

        //Check if the item is null
        asserter.assertNotNull("Item should not be null", item)

        //Check if the item is same item
        asserter.assertEquals("Item should be the same", mockItemA, item)
    }

    @Test
    fun `Accessing valid item by name with populated registry returns the requested item`() {
        //Add the test items
        populateRegistry()

        //Get the test item
        var item = ItemRegistry.getItemByName(mockItemBName)

        //Check if the item is null
        asserter.assertNotNull("Item should not be null", item)

        //Check if the item is same item
        asserter.assertEquals("Item should be the same", mockItemB, item)
    }

    @Test
    fun `Accessing invalid item by name with populated registry returns null`() {
        //Add the test items
        populateRegistry()

        //Get the test item
        var item = ItemRegistry.getItemByName("invalid item")

        //Check if the item is null
        asserter.assertNull("Item should be null", item)
    }

}