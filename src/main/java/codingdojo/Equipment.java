package codingdojo;


class Equipment {
    // TODO add a ring item that may be equipped
    //  that may also add damage modifier
    private Item leftHand;
    private Item rightHand;
    private Item head;
    private Item feet;
    private Item chest;

    Equipment(Item leftHand, Item rightHand, Item head, Item feet, Item chest) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
        this.head = head;
        this.feet = feet;
        this.chest = chest;
    }

    int getBaseDamage() {
        return leftHand.getBaseDamage() +
            rightHand.getBaseDamage() +
            head.getBaseDamage() +
            feet.getBaseDamage() +
            chest.getBaseDamage();
    }

    float getDamageModifier() {
        return leftHand.getDamageModifier() +
                rightHand.getDamageModifier() +
                head.getDamageModifier() +
                feet.getDamageModifier() +
                chest.getDamageModifier();
    }
}
