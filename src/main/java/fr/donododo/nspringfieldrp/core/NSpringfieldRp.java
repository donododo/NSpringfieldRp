package fr.donododo.nspringfieldrp.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(NSpringfieldRp.MOD_ID)
public class NSpringfieldRp {
	
	public static final String MOD_ID = "nspringfieldrp";

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	
	public NSpringfieldRp() {

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		
	}
	
	private void setup(final FMLCommonSetupEvent event) {

		LOGGER.info("[ NSpringfieldRp ] Setup Commun.");
		
		//CapabilityRpLevel.register();
		
	}
	
}
