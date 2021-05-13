package fr.donododo.nspringfieldrp.events;

import fr.donododo.nspringfield.registries.ZonesRegistry;
import fr.donododo.nspringfieldrp.core.NSpringfieldRp;
import fr.donododo.nspringfieldrp.players.PlayerProfile;
import fr.donododo.nspringfieldrp.server.zones.Zone;
import fr.donododo.nspringfieldrp.utils.Location;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NSpringfieldRp.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class ClientSubcribeEvent {

	public static PlayerProfile p;
	
	@SubscribeEvent
	public static void onBlockPlaced(BlockEvent.EntityPlaceEvent event) {
		
		System.out.println("break");
		
		Location l = new Location(event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
		
		for(Zone z : ZonesRegistry.getZonesRegistry()) {
			if(z.isInZone(l)){
				System.out.println("zone");
				break;
			}else {
				continue;
			}
		}
		/*
        if (event.getEntity() instanceof PlayerEntity) {
        	event.getEntity().getCapability(CapabilityRpLevel.IRPLEVEL_CAPABILITY).ifPresent(capa -> {
        		capa.addRpLevel(5);
        		System.out.println(capa.getRpLevel());
        	});
        }else {
        	
        }*/
        
	}

	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		/*
		if(p == null) {
			p = new PlayerProfile(event.getPlayer().getName().getContents().toString());
		}else {
			p.setRpExp(p.getRpExp() + 4);
			p.setMoney(p.getMoney() + 3.5);
			System.out.println("done");
			p.syncToClient(event.getPlayer().getServer().getPlayerList().getPlayer(event.getPlayer().getUUID()));
		}
		*/
		/*
        if (event.getPlayer() instanceof PlayerEntity) {
        	event.getPlayer().getCapability(CapabilityRpLevel.IRPLEVEL_CAPABILITY).ifPresent(capa -> {
        		capa.removeRpLevel(5);
        		System.out.println(capa.getRpLevel());
        	});
        }else {
        	
        }*/
        
	}

}
