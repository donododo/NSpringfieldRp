package fr.donododo.nspringfieldrp.capabilities.rplevel;

public class IRpLevelHolder implements IRpLevel{
	
	private int rpLevel = 0;

	@Override
	public int getRpLevel() {
		// TODO Auto-generated method stub
		return this.rpLevel;
	}

	@Override
	public void setRpLevel(int value) {
		// TODO Auto-generated method stub
		this.rpLevel = value;
	}

}
