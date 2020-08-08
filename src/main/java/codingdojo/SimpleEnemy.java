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

    List<Buff> getBuffs() {
        return buffs;
    }

    Armor getArmor() {
        return this.armor;
    }

    public int getDamageSoak() {
        return armor.getDamageSoak();
    }

    @Override
    public int getSoak() {
        int soak = Math.round(getDamageSoak() * getSoakModifierSum());
        return soak;
    }
    
    private float getSoakModifierSum() {
        return ((float) getBuffs()
                .stream()
                .mapToDouble(Buff::soakModifier)
                .sum()) +
                1f;
    }
}
