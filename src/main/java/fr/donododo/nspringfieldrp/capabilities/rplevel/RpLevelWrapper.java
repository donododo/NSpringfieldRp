package fr.donododo.nspringfieldrp.capabilities.rplevel;

import javax.annotation.Nonnull;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class RpLevelWrapper implements ICapabilitySerializable<INBT>{

	private IRpLevel holder = CapabilityRpLevel.IRPLEVEL_CAPABILITY.getDefaultInstance();
    private final LazyOptional<IRpLevel> lazyOptional = LazyOptional.of(() -> this.holder);
    
	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		// TODO Auto-generated method stub
		return CapabilityRpLevel.IRPLEVEL_CAPABILITY.orEmpty(cap, lazyOptional);
	}

	@Override
	public INBT serializeNBT() {
		// TODO Auto-generated method stub
		return CapabilityRpLevel.IRPLEVEL_CAPABILITY.writeNBT(this.holder, null);
	}

	@Override
	public void deserializeNBT(INBT nbt) {
		// TODO Auto-generated method stub
		CapabilityRpLevel.IRPLEVEL_CAPABILITY.readNBT(holder, null, nbt);
	}

}
