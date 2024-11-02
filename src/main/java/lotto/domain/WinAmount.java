package lotto.domain;

public enum WinAmount {
    Three("5,000원", 3, 5000), Four("50,000원", 4, 50000),
    Five("1,500,000원", 5, 1500000), FiveBonus("30,000,000원", 5, 30000000),
    Six("2,000,000,000원", 6, 2000000000);

    private final String amount;
    private final int number;
    private final int amountNum;

    WinAmount(String amount, int number, int amountNum) {
        this.amount = amount;
        this.number = number;
        this.amountNum = amountNum;
    }

    public String getAmount() {
        return amount;
    }

    public int getNumber() {
        return number;
    }

    public int getAmountNum() {
        return amountNum;
    }
}
