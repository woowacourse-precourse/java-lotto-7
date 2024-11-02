package lotto.model;

/*
로또 구입금액
*/
public class Money {
    private final long amount;

    public Money(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }
}
