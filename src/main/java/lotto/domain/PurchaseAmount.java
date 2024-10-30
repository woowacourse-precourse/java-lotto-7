package lotto.domain;

public class PurchaseAmount {
    private static final int UNIT = 1000;
    private final int amount;

    public PurchaseAmount(String input) {
        this.amount = parseAndValidate(input);
    }

    private int parseAndValidate(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount <= 0 || amount % UNIT != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해야 합니다.");
        }
    }

    public int getTicketCount() {
        return amount / UNIT;
    }

    public double calculateYield(int totalPrize) {
        return (double) totalPrize / amount * 100;
    }

    public int getAmount() {
        return amount;
    }
}
