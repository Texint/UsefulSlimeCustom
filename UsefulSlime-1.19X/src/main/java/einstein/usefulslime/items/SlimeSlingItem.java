package einstein.usefulslime.items;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.phys.Vec3;
import einstein.usefulslime.util.BounceHandler;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.LivingEntity;
import javax.annotation.Nonnull;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import org.jetbrains.annotations.NotNull;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;

public class SlimeSlingItem extends Item
{
    public SlimeSlingItem(final Item.Properties properties) {
        super(properties);
    }
    
    @Nonnull
    public InteractionResultHolder m_7203_(final Level level, @NotNull final Player player, final InteractionHand hand) {
        final ItemStack itemStackIn = player.m_21120_(hand);
        player.m_6672_(hand);
        return new InteractionResultHolder(InteractionResult.SUCCESS, (Object)itemStackIn);
    }
    
    public void m_5551_(final ItemStack stack, final Level level, final LivingEntity entity, final int timeLeft) {
        if (!(entity instanceof Player)) {
            return;
        }
        final Player player = (Player)entity;
        if (!player.m_20096_()) {
            return;
        }
        final int timeUsed = this.m_8105_(stack) - timeLeft;
        float i = (float)(timeUsed / 10);
        i = (i * i + i * 4.0f) / 5.0f;
        i *= 6.0f;
        if (i > 6.0f) {
            i = 6.0f;
        }
        i *= 5.0f;
        final HitResult hitResult = (HitResult)m_41435_(level, player, ClipContext.Fluid.NONE);
        if (hitResult != null && hitResult.m_6662_() == HitResult.Type.BLOCK) {
            final Vec3 vec3 = player.m_20154_().m_82541_();
            player.m_5997_(vec3.f_82479_ * -i, vec3.f_82480_ * -i / 3.0, vec3.f_82481_ * -i);
            player.m_5496_(SoundEvents.f_12469_, 1.0f, 1.0f);
            BounceHandler.addBounceHandler((LivingEntity)player);
        }
    }
    
    public UseAnim m_6164_(final ItemStack stack) {
        return UseAnim.BOW;
    }
    
    public int m_8105_(final ItemStack stack) {
        return 72000;
    }
}