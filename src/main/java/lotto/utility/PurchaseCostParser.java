package lotto.utility;

public class PurchaseCostParser {

    public static int parseToInteger(String rawPurchaseCost) {
        try {
            return Integer.parseInt(rawPurchaseCost);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }
}
