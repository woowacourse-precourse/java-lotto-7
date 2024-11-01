package lotto.util;

public enum ConstantNumbers {
    LOTTO_PRICE(1000);

    private final int number;

    ConstantNumbers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
