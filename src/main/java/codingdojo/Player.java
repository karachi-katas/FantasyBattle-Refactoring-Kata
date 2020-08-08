package codingdojo;


class Player extends Target {
    private Equipment equipment;
    private Stats stats;

    Player(Equipment equipment, Stats stats) {
        this.equipment = equipment;
        this.stats = stats;
    }

    Damage calculateDamage(Target otherTarget) {
        int baseDamage = equipment.getBaseDamage();
        float damageModifier = getDamageModifier(equipment, stats);
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

    private float getDamageModifier(Equipment equipment, Stats stats) {
        return equipment.getDamageModifier() + stats.getStrengthModifier();
    }

}
