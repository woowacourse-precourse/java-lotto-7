package lotto.model;

public class Amount {
    private final int amount;

    public Amount(String amount) {
        this.amount = Integer.parseInt(amount);
    }
    public int getAmount() {
        return amount;
    }

    public int toCount(){
        return amount / 1000;
    }
}
