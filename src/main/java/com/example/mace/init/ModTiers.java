package com.example.mace.init;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

public class ModTiers {
    // Durability 500, speed 4, +3 base damage, iron-like enchantability, repair with iron blocks
    public static final IItemTier MACE_TIER = new IItemTier() {
        @Override
        public int getUses() {
            return 500;
        }

        @Override
        public float getSpeed() {
            return 4.0F;
        }

        @Override
        public float getAttackDamageBonus() {
            return 3.0F;
        }

        @Override
        public int getLevel() {
            return 2;
        }

        @Override
        public int getEnchantmentValue() {
            return 14;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.IRON_BLOCK);
        }
    };
}
