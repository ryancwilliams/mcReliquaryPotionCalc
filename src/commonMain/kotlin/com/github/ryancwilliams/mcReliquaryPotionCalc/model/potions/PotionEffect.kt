package com.github.ryancwilliams.mcReliquaryPotionCalc.model.potions

/**
 * Potion effects.
 * @param effect The status effect that is applied.
 * @param duration The duration the effect is applied for. The duration is mesured in 15 second blocks of time.
 * @param potency The potency level of the effect.
 */
data class PotionEffect (val effect: PotionEffect, val duration: Int = 0, val potency: Int = 0) {
}
