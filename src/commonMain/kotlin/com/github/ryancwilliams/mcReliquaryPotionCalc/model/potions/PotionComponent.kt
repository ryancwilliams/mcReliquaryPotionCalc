package com.github.ryancwilliams.mcReliquaryPotionCalc.model.potions

/**
 * A component used in potion essences.
 */
interface PotionComponent {

    /**
     * A set of all effects this component has
     */
    val effects: Set<PotionEffect>

}
