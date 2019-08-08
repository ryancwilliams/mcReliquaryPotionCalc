package com.github.ryancwilliams.mcReliquaryPotionCalc.model.potions

/**
 * Repesents a PotionEssence. Potion Essences are what is used to build potions.
 */
class PotionEssence (val components: Set<PotionComponent>) : PotionComponent {

    override val effects: Set<PotionEffect>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    /**
     * Converts a set of PotionComponent into a set of Effects.
     *
     * A effect must be present in 2 components to apply to the output.
     */
    fun computeEffects(components: Set<PotionComponent>) : Set<PotionEffect> {

        /**
         * Maps each effect to all potionEffects that give this effect
         */
        val effectsMap = buildEffectsMap(components)

        TODO("Finish this")
    }

    /**
     * Builds a effects map.
     */
    private fun buildEffectsMap(components: Set<PotionComponent>) : Map<Effect, Set<PotionEffect>> {

        val effectsMap = HashMap<Effect, HashSet<PotionEffect>>()

        //For each component
        for (component in components) {
            //For each effect in component
            for (potionEffect in component.effects) {

                //Get the effect
                val effect = potionEffect.effect

                //Get the existing effects list or make a new one
                val effectList = effectsMap.get(effect) ?: HashSet<PotionEffect>()

                //Add the potion effect to the set
                effectList.add(potionEffect)

                //Add the list back to the map
                effectsMap.put(effect, effectList)
            }
        }

        return effectsMap.toMap()
    }

    /**
     * Computes the combined duration for the provided set of effects.
     */
    private fun computeCombinedDuration(effects: Set<PotionEffect>) : Int {
        TODO()
    }

    /**
     * Computes the combined potency for the provided set of effects.
     */
    private fun computeCombinedPotency(effects: Set<PotionEffect>) : Int {
        TODO()
    }

}
