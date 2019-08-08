package com.github.ryancwilliams.mcReliquaryPotionCalc.model.potions

import kotlin.math.floor
import kotlin.math.min

/**
 * Repesents a PotionEssence. Potion Essences are what is used to build potions.
 */
class PotionEssence (val components: Set<PotionComponent>) : PotionComponent {

    /**
     * The minimum number of components needed for a effect to be applied.
     */
    private val MIN_COMPOENTS = 2

    /**
     * The maximum possible duration in 15 second segments.
     */
    private val MAX_DURATION = 36000;

    /**
     * The maximum possible potency in levels.
     */
    private val MAX_POTENCY = 4;


    override val effects = computeEffects(components)

    /**
     * Converts a set of PotionComponent into a set of Effects.
     *
     * A effect must be present in 2 components to apply to the output.
     */
    fun computeEffects(components: Set<PotionComponent>) : Set<PotionEffect> {

        /**
         * Maps each effect to all potionEffects that give this effect
         */
        var effectsMap = buildEffectsMap(components)

        //Filter to only have effects from more than 2 components.
        effectsMap = effectsMap.filter { it.value.size >= MIN_COMPOENTS  }

        //All effects in the map are to be applied.

        //A set of applied effects
        var finalEffects = HashSet<PotionEffect>()

        //For each effect
        for (effectEntry in effectsMap) {
            val effect = effectEntry.key
            val effectSet = effectEntry.value

            val duration = computeCombinedDuration(effectSet)
            val potency = computeCombinedPotency(effectSet)

            finalEffects.add(PotionEffect(effect, duration, potency))
        }

        return finalEffects.toSet()
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
        //Initial duration
        var duration = 0

        for (effect in effects) {
            //Add the duration up
            duration += effect.duration
        }

        //Do some math magic the real reliquary does

        duration = floor(duration / 1.2).toInt()

        if (effects.size == 3) {
            duration = floor(duration / 1.1).toInt()
        }

        return min(duration, MAX_DURATION)
    }

    /**
     * Computes the combined potency for the provided set of effects.
     */
    private fun computeCombinedPotency(effects: Set<PotionEffect>) : Int {
        //Initial potency
        var potency = 0

        for (effect in effects) {
            //Add the potency up
            potency += effect.potency
        }

        return minOf(potency, MAX_POTENCY)
    }

}
