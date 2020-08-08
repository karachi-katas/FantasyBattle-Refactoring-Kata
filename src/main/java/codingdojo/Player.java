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
        int soak = other.getSoak();
        return new Damage(Math.max(0, totalDamage - soak));
    }

    public int getTotalDamage() {
        int baseDamage = inventory.getBaseDamage();
        float damageModifier = inventory.getDamageModifier(stats.getModifiedStrength());
        int totalDamage = Math.round(baseDamage * damageModifier);
        return totalDamage;
    }

    @Override
    public int getSoak() {
        int soak = getTotalDamage();
        // TODO: Not implemented yet
        //  Add friendly fire
        return soak;
    }
}
