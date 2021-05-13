package fr.donododo.nspringfieldrp.rendering;

import com.mojang.blaze3d.matrix.MatrixStack;

import fr.donododo.nspringfieldrp.core.NSpringfieldRp;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.IngameGui;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NSpringfieldRp.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class HudRendering {
	
	@SubscribeEvent
	public static void HudRenderEvent(RenderGameOverlayEvent.Post event) {
		
		MatrixStack matrix = event.getMatrixStack();
		IngameGui.drawCenteredString(matrix, Minecraft.getInstance().font, "daoidcaoidahodazhdahfdahoid", 10, 10, 10);
	}

}
