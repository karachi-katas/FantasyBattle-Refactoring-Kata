package codingdojo;


class Player extends Target {
    private Equipment equipment;
    private Stats stats;

    Player(Equipment equipment, Stats stats) {
        this.equipment = equipment;
        this.stats = stats;
    }

    Damage calculateDamage(Target otherTarget) {
        int totalDamage = getTotalDamage();
        int soak = otherTarget.getSoak(totalDamage);
        int damage = totalDamage - soak;
        return new Damage(damage);
    }

    private int getTotalDamage() {
        int baseDamage = equipment.getBaseDamage();
        float damageModifier = getDamageModifier(equipment, stats);
        return Math.round(baseDamage * damageModifier);
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
