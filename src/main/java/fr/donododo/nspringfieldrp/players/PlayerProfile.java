package fr.donododo.nspringfieldrp.players;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.Supplier;

import fr.donododo.nspringfield.registries.NSPjob;
import fr.donododo.nspringfield.registries.NetworksRegistry;
import fr.donododo.nspringfieldrp.utils.JobLevelCalculator;
import fr.donododo.nspringfieldrp.utils.RPLevelCalculator;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.PacketDistributor;

public class PlayerProfile {
	
	public int rpExp = 0;
	
	public double money = 0;

	public String username;
	public String uuid;
	
	public HashMap<NSPjob, Integer> jobExps = new HashMap<NSPjob, Integer>();

	public PlayerProfile(String uuid) {
		ServerPlayerEntity e  = Minecraft.getInstance().player.getServer().getPlayerList().getPlayer(UUID.fromString(uuid));
		this.username = e.getName().getContents().toString();
		this.uuid = uuid;
	}

	public void syncToClient(ServerPlayerEntity p) {
		NetworksRegistry.CHANNEL.send(PacketDistributor.PLAYER.with(() -> p), this);
	}
	
	public PlayerProfile load() {
		return null;
	}
	
	public void saveProfile() {
		
	}
	
    public static void encode(PlayerProfile packet, PacketBuffer buffer)
    {
        buffer.writeInt(packet.rpExp);
        buffer.writeDouble(packet.money);
    }
    
    public static PlayerProfile decode(PacketBuffer buffer)
    {
        PlayerProfile instance = new PlayerProfile(Minecraft.getInstance().player.getName().getContents().toString());
        
        //instance.setRpExp(buffer.readInt());
       // instance.setMoney(buffer.readDouble());
        
        return instance;
    }
    
    public static void handle(PlayerProfile packet, Supplier<NetworkEvent.Context> ctx)
    {
        System.out.println("RpExp : " + packet.rpExp);
        System.out.println("Money : " + packet.money);
        ctx.get().setPacketHandled(true);
    }
	
    // Getters
    
    public int rpExp() { // Return the number or RP exp the player have
    	return rpExp;
    }
    
    public int getRpLevel() { // Return the calculated RP level the player have
    	RPLevelCalculator calc = new RPLevelCalculator();
    	return calc.calculateRpLevel(rpExp);
    }
    
    public double getMoney() { // Return the money the player have
    	return money;
    }
    
    private HashMap<NSPjob, Integer> getJobExp() { // Return the list of job / experience the player have in each job 
    	return jobExps;
    }
    
    public int getJobExp(NSPjob job) { // Return the number of the exp the player have for the job
    	if(getJobExp().isEmpty()) {
    		return 0;
    	}else {
    		if(getJobExp().containsKey(job)) {
    			return getJobExp().get(job);
    		}else {
    			return 0;
    		}
    	}
    }
    
    public int getJobLevel(NSPjob job) { // Return the calculated level of the job the player have
    	JobLevelCalculator calc = new JobLevelCalculator();
    	
    	return calc.calculateJobLevel(getJobExp(job));
    }
    
    // Getters
    
    // Setters
    
    public void setRpExp(int exp) { // Set the number of RP exp the player have
    	this.rpExp = exp;
    }
    
    public void setMoney(int money) { // Set the amount of money the player have
    	this.money = money;
    }
    
    public void setJobExp(NSPjob job, int exp) { // Set the experience on the job the player have
    	if(jobExps.containsKey(job)) {
    		jobExps.replace(job, exp);
    	}else {
    		jobExps.put(job, exp);
    	}
    }
    
    // Setters
    
 } 
