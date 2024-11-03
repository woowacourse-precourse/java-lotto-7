package lotto.domain;

public enum WinAmount {
    Three("5,000원", 5000, 3), Four("50,000원", 50000, 4),
    Five("1,500,000원", 1500000, 5), FiveBonus("30,000,000원", 30000000, 5),
    Six("2,000,000,000원", 2000000000, 6);

    private final String amount;
    private final int amountNum;
    private final int number;

    WinAmount(String amount, int amountNum, int number) {
        this.amount = amount;
        this.amountNum = amountNum;
        this.number = number;

    }

    public String getAmount() {
        return amount;
    }

    public int getAmountNum() {
        return amountNum;
    }

    public int getNumber() {
        return number;
    }

    public static WinAmount determineWinAmount(int correctNumber, boolean fiveAndBonus) {
        if (correctNumber == 5 && fiveAndBonus) {
            return FiveBonus;
        }
        for (WinAmount winAmount : WinAmount.values()) {
            if (winAmount.getNumber() == correctNumber) {
                return winAmount;
            }
        }
        return null;
    }
}
