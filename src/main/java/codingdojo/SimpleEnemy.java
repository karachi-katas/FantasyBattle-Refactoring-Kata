package codingdojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleEnemy extends Target {

    private Armor armor;
    private List<Buff> buffs;

    public SimpleEnemy(Armor armor, List<Buff> buffs) {
        this.armor = armor;
        this.buffs = buffs;
    }

    private double sumOfSoakModifier() {
        return buffs
                .stream()
                .mapToDouble(Buff::soakModifier)
                .sum();
    }

    @Override
    int getSoak(int totalDamage) {
        int soak;
        soak = Math.round(
            armor.getDamageSoak() * ( ((float) sumOfSoakModifier()) + 1f ) );
        return soak;
    }
}
