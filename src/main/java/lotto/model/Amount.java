package lotto.model;

public class Amount {
    private final int amount;

    public Amount(int amount) {
        this.amount = amount;
    }
    public int getAmount() {
        return amount;
    }

    public int toCount(){
        return amount / 1000;
    }
}
