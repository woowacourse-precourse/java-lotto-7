package lotto.domain;

public class PurchaseAmount {

    public static final String SHOULD_INTEGER_MESSAGE = "구입금액을 숫자로 입력해주세요.";
    private int amount;

    public PurchaseAmount(String rawPurchaseAmount) {
        int purchaseAmount = toInt(rawPurchaseAmount);
        this.amount = purchaseAmount;
    }

    private int toInt(String rawPurchaseAmount) {
        try {
            return Integer.parseInt(rawPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] " + SHOULD_INTEGER_MESSAGE);
        }
    }
}
