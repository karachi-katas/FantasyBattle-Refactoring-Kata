package codingdojo;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

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
        assertEquals(10, damage.getAmount());
    }

    // choose this one if you are not familiar with mocks
    @Ignore("Test is not finished yet")
    @Test
    public void damageCalculations() {
        Item sword = new BasicItem("sword", 10, 2);
        Item helmet = new BasicItem("helmet", 10, 2);
        Item boots = new BasicItem("boots", 10, 2);
        Equipment equipment = new Equipment(sword, sword, helmet, boots);
        Inventory inventory = new Inventory(equipment);
        Stats stats = new Stats(0);
        SimpleEnemy target = new SimpleEnemy(null, null);
        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(10, damage.getAmount());
    }
}