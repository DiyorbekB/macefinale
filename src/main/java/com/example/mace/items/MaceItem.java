package com.example.mace.items;

import com.example.mace.init.ModSounds;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class MaceItem extends SwordItem {
    
    public MaceItem(IItemTier tier, int attackDamage, float attackSpeed, Properties props) {
        // SwordItem constructor: super(tier, damageAboveBase, speed, properties)
        super(tier, attackDamage, attackSpeed, props);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean hit = super.hurtEnemy(stack, target, attacker);
        
        // Special: if attacker is falling (critical), deal extra damage = fall distance
        if (hit && attacker instanceof PlayerEntity) {
            double fallDist = attacker.fallDistance;
            if (fallDist > 0.0D) {
                float bonus = (float) fallDist;
                target.hurt(DamageSource.playerAttack((PlayerEntity) attacker), bonus);
                
                // Play custom sound
                attacker.level.playSound(null, attacker.blockPosition(), 
                    ModSounds.MACE_HIT.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
            }
        }
        return hit;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, 
                               List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new StringTextComponent("Deals bonus damage when striking while falling.")
            .withStyle(TextFormatting.GRAY));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
