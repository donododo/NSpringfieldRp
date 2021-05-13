package fr.donododo.nspringfieldrp.capabilities.rplevel;

import javax.annotation.Nullable;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class DefaultRpLevelStorage implements Capability.IStorage<IRpLevel>{

	@Nullable
	@Override
	public INBT writeNBT(Capability<IRpLevel> capability, IRpLevel instance, Direction side) {
		// TODO Auto-generated method stub
		return IntNBT.valueOf(instance.getRpLevel());
	}

	@Override
	public void readNBT(Capability<IRpLevel> capability, IRpLevel instance, Direction side, INBT nbt) {
		// TODO Auto-generated method stub
		instance.setRpLevel(Integer.parseInt(nbt.getAsString()));
	}
	
}
