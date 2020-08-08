package codingdojo;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
        assertEquals(10, damage.getAmount());
    }

    // choose this one if you are not familiar with mocks
    //    @Ignore("Test is not finished yet")

    @Test
    public void testEquipment() {
        Item leftHand = new BasicItem("round shield", 0, (float)1.4);
        Item rightHand = new BasicItem("excalibur", 20, (float)1.5);
        Item head = new BasicItem("helmet", 0, (float)1.2);
        Item feet = new BasicItem("boots", 0, (float)0.1);
        Item chest = new BasicItem("steel plate", 0, (float)1.4);
        Equipment equipment = new Equipment(leftHand, rightHand, head, feet, chest);
        assertEquals(equipment.getBaseDamage(), 20);
    }

    @Test
    public void testSoak() {
        Armor armor = new SimpleArmor(5);
        List<Buff> buffList = new ArrayList<Buff>();
        buffList.add(new BasicBuff(1.0f, 1.0f));

        SimpleEnemy enemy = new SimpleEnemy(armor, buffList);
        assertEquals(enemy.getSoak(), 10);
    }

    @Test
    public void damageCalculations() {
        Item leftHand = new BasicItem("round shield", 0, (float)1.4);
        Item rightHand = new BasicItem("excalibur", 20, (float)1.5);
        Item head = new BasicItem("helmet of swiftness", 0, (float)1.2);
        Item feet = new BasicItem("ten league boots", 0, (float)0.1);
        Item chest = new BasicItem("breastplate of steel", 0, (float)1.4);

        Equipment equipment = new Equipment(leftHand, rightHand, head, feet, chest);

        Inventory inventory = new Inventory(equipment);
        Stats stats = new Stats(0);

        Armor armor = new SimpleArmor(5);
        List<Buff> buffList = new ArrayList<Buff>();
        buffList.add(new BasicBuff(1.0f, 1.0f));

        SimpleEnemy target = new SimpleEnemy(armor, buffList);
        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(102, damage.getAmount());
    }
}