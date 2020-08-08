package codingdojo;


class Player extends Target {
    private Inventory inventory;
    private Equipment equipment;
    private Stats stats;

    Player(Inventory inventory, Equipment equipment, Stats stats) {
        this.inventory = inventory;
        this.equipment = equipment;
        this.stats = stats;
    }

    Damage calculateDamage(Target otherTarget) {
        int baseDamage = equipment.getBaseDamage();
        float damageModifier = getDamageModifier();
        int totalDamage = Math.round(baseDamage * damageModifier);
        int soak = otherTarget.getSoak(totalDamage);
        return new Damage(Math.max(0, totalDamage - soak));
    }

    @Override
    int getSoak(int totalDamage) {
        // TODO: Not implemented yet
        //  Add friendly fire
        return totalDamage;
    }

    private float getDamageModifier() {
        Item leftHand = equipment.getLeftHand();
        Item rightHand = equipment.getRightHand();
        Item head = equipment.getHead();
        Item feet = equipment.getFeet();
        Item chest = equipment.getChest();
        float strengthModifier = stats.getStrength() * 0.1f;
        return strengthModifier +
            leftHand.getDamageModifier() +
            rightHand.getDamageModifier() +
            head.getDamageModifier() +
            feet.getDamageModifier() +
            chest.getDamageModifier();
    }

}
