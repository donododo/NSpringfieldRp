package fr.donododo.nspringfieldrp.capabilities.rplevel;

import fr.donododo.nspringfieldrp.core.NSpringfieldRp;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NSpringfieldRp.MOD_ID)
public class CapabilityRpLevel {
	
	public static final ResourceLocation CAP_RPLEVEL = new ResourceLocation(NSpringfieldRp.MOD_ID, "rplevel");

	@CapabilityInject(IRpLevel.class)
	public static final Capability<IRpLevel> IRPLEVEL_CAPABILITY = null;

	public static void register()
	{
	    CapabilityManager.INSTANCE.register(IRpLevel.class, new DefaultRpLevelStorage(), IRpLevelHolder::new);
	}
	
	@SubscribeEvent
	public static void attachToEntities(AttachCapabilitiesEvent<Entity> event)
	{
	    if(event.getObject() instanceof PlayerEntity && !event.getObject().getEntity().getCommandSenderWorld().isClientSide)
	    {
	        RpLevelWrapper wrapper = new RpLevelWrapper();
	        event.addCapability(CAP_RPLEVEL, wrapper);
	    }
	}
	
	@SubscribeEvent
	public static void copyCapabilities(PlayerEvent.Clone event)
	{
	    if(event.isWasDeath() && !event.getPlayer().getCommandSenderWorld().isClientSide)
	    {
        	event.getOriginal().getCapability(CapabilityRpLevel.IRPLEVEL_CAPABILITY).ifPresent(capa -> {
            	event.getEntity().getCapability(CapabilityRpLevel.IRPLEVEL_CAPABILITY).ifPresent(cap -> {
            		cap.setRpLevel(capa.getRpLevel());
            	});
        	});
	    }
	}

}
