package fr.donododo.nspringfield.registries;

import fr.donododo.nspringfieldrp.core.NSpringfieldRp;
import fr.donododo.nspringfieldrp.players.PlayerProfile;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class NetworksRegistry {

	public static final String PROTOCOL_VERSION = String.valueOf(1);
	
	public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder
	        .named(new ResourceLocation(NSpringfieldRp.MOD_ID, "nspringfieldrp"))
	        .networkProtocolVersion(() -> PROTOCOL_VERSION)
	        .clientAcceptedVersions(PROTOCOL_VERSION::equals)
	        .serverAcceptedVersions(PROTOCOL_VERSION::equals)
	        .simpleChannel();

	public static void registerNetworkPackets()
	{
		
	    CHANNEL.messageBuilder(PlayerProfile.class, 0).encoder(PlayerProfile::encode).decoder(PlayerProfile::decode).consumer(PlayerProfile::handle).add();
	    
	}
}
