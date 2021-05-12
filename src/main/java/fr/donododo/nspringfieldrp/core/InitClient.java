package fr.donododo.nspringfieldrp.core;

import fr.donododo.nspringfieldrp.rendering.HatLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.geckolib3.GeckoLib;

@Mod.EventBusSubscriber(modid = NSpringfieldRp.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class InitClient {
	
	@SubscribeEvent
	public static void clientSetup(final FMLClientSetupEvent event) {
		
		NSpringfieldRp.LOGGER.info("[ NSpringfieldRp ] Setup côté Client.");
		
		EntityRendererManager manager = Minecraft.getInstance().getEntityRenderDispatcher();
		for (PlayerRenderer renderer : manager.getSkinMap().values()) {
			renderer.addLayer(new HatLayer<>(renderer));
		}
		
		GeckoLib.initialize();
		
	}
	
}
