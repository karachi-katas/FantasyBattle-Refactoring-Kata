package codingdojo;


class Player extends Target {
    private Inventory inventory;
    private Stats stats;

    Player(Inventory inventory, Stats stats) {
        this.inventory = inventory;
        this.stats = stats;
    }

    Damage calculateDamage(Target other) {

        int totalDamage = getTotalDamage();
        int soak = other.getSoak(other, totalDamage);
        return new Damage(subtract(totalDamage, soak));
    }

    private int subtract(int totalDamage, int soak) {
        return Math.max(0, totalDamage - soak);
    }

    private int getTotalDamage() {
        int baseDamage = getBaseDamage();
        float damageModifier = getDamageModifier();
        return Math.round(baseDamage * damageModifier);
    }

    public int getSoak(Target other, int totalDamage) {
            // TODO: Not implemented yet
            //  Add friendly fire

        return totalDamage;
    }



    //LAW OF DELEMETER

    private float getDamageModifier() {
        float sumOfDamageModifier = this.inventory.getSumOfDamageModifier();

        float strengthModifier = stats.getStrength() * 0.1f;
        return strengthModifier + sumOfDamageModifier;
    }

    private int getBaseDamage() {
        return this.inventory.getSumOfBaseDamage();
    }
}
