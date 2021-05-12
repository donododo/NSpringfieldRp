package fr.donododo.nspringfieldrp.core;

import fr.donododo.nspringfield.registries.NSPRegistries;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;

@Mod.EventBusSubscriber(modid = NSpringfieldRp.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class InitServer {
	
	@SubscribeEvent
	public static void serverSetup(final FMLDedicatedServerSetupEvent event) {
		
		NSpringfieldRp.LOGGER.info("[ NSpringfieldRp ] Setup côté Serveur.");		
		NSPRegistries.setupServerRegistries();
		
	}
}
