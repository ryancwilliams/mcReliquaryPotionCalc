package com.github.ryancwilliams.mcReliquaryPotionCalc.model.registry

/**
 * A abstract registry. This can be used to hold objects to be referenced later.
 */
abstract class Registry<I> {

    /**
     * A set of all known items.
     */
    protected val items = HashSet<I>()

    /**
     * Adds the provided item to this registry.
     */
    fun addToRegistry(item: I) {
        //Check if item is in this registry
        if (this.itemInRegistry(item)) {
            //this item is in the registry so we are done.
            return
        }

        //Add the item to the hash set
        this.items.add(item)

        //Add the item to the index
        this.addToIndex(item)
    }

    /**
     * Checks if a item is in the registry.
     *
     * @return TRUE if the item is in this registry
     */
    fun itemInRegistry(item: I) : Boolean {
        return this.items.contains(item)
    }

    /**
     * Gets the entire registry as a set.
     */
    fun getRegistry() : Set<I> {
        return this.items.toSet()
    }

    /**
     * Adds this item to the indexes in this registry. This is used to speed up access.
     */
    protected abstract fun addToIndex(item: I)

}
