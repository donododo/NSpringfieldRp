package fr.donododo.nspringfieldrp.capabilities.rplevel;

public interface IRpLevel {

    int getRpLevel();
    void setRpLevel(int value);

    default void removeRpLevel(int value) {
        this.setRpLevel(this.getRpLevel() - value);
    }
 
    default void addRpLevel(int value) {
        this.setRpLevel(this.getRpLevel() + value);
    }
    
}
