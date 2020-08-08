package codingdojo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class SimpleEnemyShould {

    @Test
    public void soakDamageWithArmor() {

        Armor armor = new SimpleArmor(10);
        Buff buff = new BasicBuff(0,10000);
        Buff buff2 = new BasicBuff(0,10000);
        List<Buff> buffList = Arrays.asList(buff, buff2);
        SimpleEnemy simplyEnemy = new SimpleEnemy(armor, buffList);

        int soak = simplyEnemy.getSoak(500);

        assertEquals(10, soak);
    }


}
