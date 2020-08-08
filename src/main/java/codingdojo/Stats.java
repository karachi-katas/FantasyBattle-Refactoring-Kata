package codingdojo;

public class Stats {
    // TODO add dexterity that will both help with soak and damage.
    //  but half of what strength gives.
    private int strength;

    public Stats(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public float getModifiedStrength() {
        return strength * 0.1f;
    }
}
