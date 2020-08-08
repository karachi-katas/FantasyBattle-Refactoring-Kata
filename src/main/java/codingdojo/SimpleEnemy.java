package codingdojo;

import java.util.List;

public class SimpleEnemy extends Target {

    private Armor armor;
    private List<Buff> buffs;

    public SimpleEnemy(Armor armor, List<Buff> buffs) {
        this.armor = armor;
        this.buffs = buffs;
    }

    List<Buff> getBuffs() {
        return buffs;
    }

    float sumOfSoakModifiers() {
        return (float) getBuffs()
            .stream()
            .mapToDouble(Buff::soakModifier)
            .sum();
    }

    @Override
    int getSoak(int totalDamage) {
        return Math.round(
            this.armor.getDamageSoak() *
            (
                sumOfSoakModifiers() + 1f
            )
        );
    }
}
