package asd.fred.wynncraft_spell_caster.mixin;

import asd.fred.wynncraft_spell_caster.Config;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityRenderer.class)
public abstract class HideArrowsMixin {
    @Inject(method = "shouldRender", at = @At("HEAD"), cancellable = true)
    private void wynncraftSpellCaster$hideArrows(Entity entity, Frustum frustum, double x, double y, double z, CallbackInfoReturnable<Boolean> cir) {
        if ((entity instanceof ArrowEntity || entity instanceof SpectralArrowEntity) && Config.getConfigData().hide_arrows) {
            cir.setReturnValue(false);
        }
    }
}
