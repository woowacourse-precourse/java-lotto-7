package lotto.parser;


import lotto.domain.LottoConstants;

public class PurchaseAmountParser {
    public static int parse(String input) {
        validateInput(input);
        return processInput(input);
    }

    private static void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 입력해야 합니다.");
        }
    }

    private static int processInput(String input) {
        int purchaseAmount = inputToPurchaseAmount(input);
        return validatePurchaseAmount(purchaseAmount);
    }

    private static int inputToPurchaseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다. (예: 1000)");
        }
    }

    private static int validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % LottoConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] " + LottoConstants.LOTTO_PRICE +"단위의 양수만 입력 가능합니다.");
        }
        return purchaseAmount;
    }

}
