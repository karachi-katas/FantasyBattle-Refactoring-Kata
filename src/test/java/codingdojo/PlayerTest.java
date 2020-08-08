package codingdojo;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class PlayerTest {

    // choose this one if you are familiar with mocks
    @Ignore("Test is not finished yet")
    @Test
    public void damageCalculationsWithMocks() {
        Inventory inventory = mock(Inventory.class);
        Stats stats = mock(Stats.class);
        SimpleEnemy target = mock(SimpleEnemy.class);

        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(390, damage.getAmount());
    }

    // choose this one if you are not familiar with mocks
    @Ignore("Test is not finished yet")
    @Test
    public void damageCalculations() {
        Item sword = new BasicItem("sword", 10, 2);
        Item helmet = new BasicItem("helmet", 10, 2);
        Item chestplate = new BasicItem("chestplate", 10, 2);
        Item boots = new BasicItem("boots", 10, 2);
        Equipment equipment = new Equipment(sword, sword, helmet, boots,chestplate);
        Inventory inventory = new Inventory(equipment);
        Stats stats = new Stats(0);

        Armor armor = new SimpleArmor(10);
        Buff buff = new BasicBuff(10,10000);
        Buff buff2 = new BasicBuff(10,10000);
        List<Buff> buffList = Arrays.asList(buff, buff2);
        SimpleEnemy target = new SimpleEnemy(armor, buffList);
        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(290, damage.getAmount());
    }
}
