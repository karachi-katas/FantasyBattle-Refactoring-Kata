package codingdojo;

public class Inventory {
    private Equipment equipment;

    public Inventory(Equipment equipment) {
        this.equipment = equipment;
    }

    Equipment getEquipment() {
        return equipment;
    }

    public int getBaseDamage() {
        return equipment.getBaseDamage();
    }

    public float getDamageModifier(float strengthModifier) {
        return equipment.getDamageModifier(strengthModifier);
    }
}
