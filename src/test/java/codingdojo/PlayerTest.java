package codingdojo;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;

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

        Damage damage = new Player(null, stats).calculateDamage(target);
        assertEquals(10, damage.getAmount());
    }

    // choose this one if you are not familiar with mocks
//    @Ignore("Test is not finished yet")
    @Test
    public void damageCalculations() {

        Item flashySwordOfDanger=new BasicItem("flashy sword of danger",10,1.0f);
        Item excalibur=new BasicItem("excalibur",20,1.5f);
        Item roundShield=new BasicItem("round shield",0,1.4f);
        Item tenLeagueBoots=new BasicItem("ten league boots",0,0.1f);
        Item helmetOfSwiftness=new BasicItem("helmet of swiftness",0,1.2f);
        Item breastplateOfSteel=new BasicItem("breastplate of steel",0,1.4f);

        Equipment equipment = new Equipment(roundShield,excalibur,helmetOfSwiftness,tenLeagueBoots,breastplateOfSteel);

        Inventory inventory = new Inventory(equipment);
        Stats stats = new Stats(0);
        Buff basicBuff=new BasicBuff(1.0f,1.0f);
        SimpleEnemy target = new SimpleEnemy( new SimpleArmor(5), Collections.singletonList(basicBuff));
        Damage damage = new Player(equipment, stats).calculateDamage(target);
        assertEquals(102, damage.getAmount());
    }
}