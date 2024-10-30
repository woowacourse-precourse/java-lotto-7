package lotto.domain;

public class Money {
    private final int amount;

    public Money(String input) {
        this.amount = Integer.parseInt(input);
    }
}
