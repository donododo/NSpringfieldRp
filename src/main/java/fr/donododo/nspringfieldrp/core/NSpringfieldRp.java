package fr.donododo.nspringfieldrp.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.donododo.nspringfield.registries.NSPRegistries;
import fr.donododo.nspringfieldrp.capabilities.rplevel.CapabilityRpLevel;
import fr.donododo.nspringfieldrp.rendering.HatLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

@Mod(NSpringfieldRp.MOD_ID)
public class NSpringfieldRp {
	
	public static final String MOD_ID = "nspringfieldrp";

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	
	public NSpringfieldRp() {

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
		
	}
	
	private void setup(final FMLCommonSetupEvent event) {

		LOGGER.info("[ NSpringfieldRp ] Setup Commun.");
		
		//CapabilityRpLevel.register();
		
	}
	
	private void clientSetup(final FMLClientSetupEvent event) {
		
		LOGGER.info("[ NSpringfieldRp ] Setup côté Client.");
		
		EntityRendererManager manager = Minecraft.getInstance().getEntityRenderDispatcher();
		for (PlayerRenderer renderer : manager.getSkinMap().values()) {
			renderer.addLayer(new HatLayer<>(renderer));
		}
		
		GeckoLib.initialize();
		
	}
	
	private void serverSetup(final FMLDedicatedServerSetupEvent event) {
		
		LOGGER.info("[ NSpringfieldRp ] Setup côté Serveur.");		
		NSPRegistries.setupServerRegistries();
		
	}
	
}
