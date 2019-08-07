package com.github.ryancwilliams.mcReliquaryPotionCalc.model.items

import com.github.ryancwilliams.mcReliquaryPotionCalc.model.registry.Registry

/**
 * A registry for all known items.
 */
object ItemRegistry : Registry<Item>() {

    /**
     * A index of all known items by name.
     *
     * This is used for quick access to the registry.
     */
    private val indexByItemName = HashMap<String, Item>()

    /**
     * Gets a item by its name.
     *
     * @return The item or NULL if the item is not in this registry.
     */
    fun getItemByName(name: String) : Item? {
        return this.indexByItemName.get(normalizeName(name))
    }

    override fun addToIndex(item: Item) {
        this.addToIndexByItemName(item)
    }

    /**
     * Adds this item to the by name index.
     */
    private fun addToIndexByItemName(item: Item) {
        //Get the name
        val name = normalizeName(item.itemName);

        //Add to the index
        this.indexByItemName.put(name, item)
    }

    /**
     * Converts name strings to a standard form.
     */
    private fun normalizeName(name: String) : String {
        return name.toUpperCase();
    }

}
