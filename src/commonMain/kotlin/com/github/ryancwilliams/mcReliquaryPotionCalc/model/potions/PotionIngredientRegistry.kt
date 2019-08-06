package com.github.ryancwilliams.mcReliquaryPotionCalc.model.potions

import com.github.ryancwilliams.mcReliquaryPotionCalc.model.items.Item
import com.github.ryancwilliams.mcReliquaryPotionCalc.model.registry.Registry

object PotionIngredientRegistry : Registry<PotionIngredient>() {

    /**
     * A index of all known PotionIngredients by item.
     *
     * This is used for quick access to the registry.
     */
    val indexByItem = HashMap<Item, PotionIngredient>()

    /**
     * A index of all known PotionIngredients by Effect.
     *
     * The ingredients are stored in a set
     *
     * This is used for quick access to the registry.
     */
    val indexByEffect = HashMap<Effect, HashSet<PotionIngredient>>()

    /**
     * Gets a PotionIngredient by its item.
     *
     * @return The ingredient or NULL if the item is not in this registry.
     */
    fun getIngredientByItem(item: Item) : PotionIngredient? {
        return this.indexByItem.get(item);
    }

    /**
     * Gets a collection of all known PotionIngredients by its effect.
     *
     * @return The collection or a empty collection if the effect is not in this registry.
     */
    fun getIngredientsByEffect(effect: Effect) : Set<PotionIngredient> {

        //get the ingredients
        val ingredients = this.indexByEffect.get(effect);

        if (ingredients == null) {
            //Return a empty collection
            return HashSet<PotionIngredient>().toSet();
        }

        //Return the ingredients as a set
        return ingredients.toSet();

    }

    override fun addToIndex(item: PotionIngredient) {
        this.addToIndexByItem(item)
        this.addToIndexByEffect(item)
    }

    /**
     * Adds this PotionIngredient to the by Item index.
     */
    private fun addToIndexByItem(ingredient: PotionIngredient) {
        //Add to the index
        this.indexByItem.put(ingredient.item, ingredient)
    }

    /**
     * Adds this PotionIngredient to the by effect index.
     */
    private fun addToIndexByEffect(ingredient: PotionIngredient) {
        //Extract effects
        var effects = ingredient.effects

        //For each effect
        for (effect in effects.map { it.effect }) {

            //Pull effect set from index or a empty set if no set exists
            // :? is the elvis operator. It says to use a new hashset if the get() returns null
            var ingredientSet = this.indexByEffect.get(effect) ?: HashSet<PotionIngredient>()

            //Add the ingredient to the set
            ingredientSet.add(ingredient)

            //Put the updated set back in the index
            this.indexByEffect.put(effect, ingredientSet)
        }
    }

}