package com.github.ryancwilliams.mcReliquaryPotionCalc.model.potions

/**
 * Effect types present in base minecraft.
 */
enum class EffectType {
    POSITIVE,
    NEGATIVE,
    NETURAL
}

/**
 * Status effects present in base minecraft.
 */
enum class Effect (val effectName: String, val effectDescription: String = "", val effectType: EffectType = EffectType.NETURAL) {
    SPEED("Speed", "Increases walking speed", EffectType.POSITIVE),
    SLOWNESS("Slowness", "Decreases walking speed", EffectType.NEGATIVE),
    HASTE("Haste", "Increases mining and attack speed", EffectType.POSITIVE),
    MINING_FATIGUE("Mining Fatigue", "Decreases mining and attack speed", EffectType.NEGATIVE),
    STRENGTH("Strength", "Increases melee damage", EffectType.POSITIVE),
    INSTANT_HEALTH("Instant Health", "Heals entities, damages undead", EffectType.POSITIVE),
    INSTANT_DAMAGE("Instant Damage", "Damages entities, heals undead", EffectType.NEGATIVE),
    JUMP_BOOST("Jump Boost", "Increases jump height and reduces fall damage", EffectType.POSITIVE),
    NAUSEA("Nausea", "Wobbles and warps the screen", EffectType.NEGATIVE),
    REGENERATION("Regeneration", "Regenerates health over time", EffectType.POSITIVE),
    RESISTANCE("Resistance", "Reduces most damage", EffectType.POSITIVE),
    FIRE_RESISTANCE("Fire Resistance", "Immunity to fire and lava.", EffectType.POSITIVE),
    WATER_BREATHING("Water Breathing", "Prevents drowning", EffectType.POSITIVE),
    INVISIBILITY("Invisibility", "Grants invisibility", EffectType.POSITIVE),
    BLINDNESS("Blindness", "Impairs vision and disables the ability to sprint and critical hit", EffectType.NEGATIVE),
    NIGHT_VISION("Night Vision", "Negates darkness", EffectType.POSITIVE),
    HUNGER("Hunger", "Increases food exhaustion", EffectType.NEGATIVE),
    WEAKNESS("Weakness", "Decreases melee damage", EffectType.NEGATIVE),
    POISON("Poison", "Inflicts damage over time (but can't kill)", EffectType.NEGATIVE),
    WITHER("Wither", "Inflicts damage over time (can kill)", EffectType.NEGATIVE),
    HEALTH_BOOST("Health Boost", "Increases maximum health", EffectType.POSITIVE),
    ABSORPTION("Absorption", "Adds damage absorption", EffectType.POSITIVE),
    SATURATION("Saturation", "Restores hunger and saturation", EffectType.POSITIVE),
    GLOWING("Glowing", "Outlines entities (can be seen through blocks)", EffectType.NEGATIVE),
    LEVITATION("Levitation", "Floats entities upwards", EffectType.NEGATIVE),
    LUCK("Luck", "Can increase chances of high-quality and more loot", EffectType.POSITIVE),
    BAD_LUCK("Bad Luck", "Can reduce chances of high-quality and more loot", EffectType.NEGATIVE),
    SLOW_FALLING("Slow Falling", "Decreases falling speed and negates fall damage", EffectType.POSITIVE),
    CONDUIT_POWER("Conduit Power", "Increases underwater visibility and mining speed, prevents drowning", EffectType.POSITIVE),
    DOLPHINS_GRACE("Dolphin's Grace", "Increases swimming speed", EffectType.POSITIVE),
    BAD_OMEN("Bad Omen", "Causes an illager raid to start upon entering a village", EffectType.NEGATIVE),
    HERO_OF_THE_VILLAGE("Hero of the Village", "Gives discounts on trades", EffectType.POSITIVE)
}
