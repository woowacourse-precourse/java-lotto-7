package lotto.domain;

public class Amount {
    private final int amount;

    public Amount(String strAmount){
        this.amount = parseToInt(strAmount);
    }

    public int getAmount() {
        return amount;
    }

    private int parseToInt(String strAmount){
        return Integer.parseInt(strAmount);
    }
}
