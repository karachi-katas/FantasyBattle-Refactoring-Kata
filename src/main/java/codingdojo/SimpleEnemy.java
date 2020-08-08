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

    public int getEnemySoak() {
        int soak;
        soak = Math.round(
            this.getArmor().getDamageSoak() *
                (
                    ((float) this.getBuffs()
                            .stream()
                            .mapToDouble(Buff::soakModifier)
                            .sum()) +
                            1f
                )
        );
        return soak;
    }

}
