package codingdojo;

class Damage {
    private int amount;

    Damage(int amount) {
        this.amount = Math.max(0, amount);
    }

    int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
