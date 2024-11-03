package lotto.domain;

import lotto.common.LottoValidateUtil;

public class Purchase {
    private final int amount;

    public Purchase(String amount) {
        this.amount = convertStringToInt(amount);
    }

    public int getAmount() {
        return amount;
    }

    private int convertStringToInt(String amount) {
        int parsedAmount;

        if (amount == null || amount.isBlank()) {
            amount = "";
        }
        String cleanAmount = amount.replace(" ", "");

        try {
            parsedAmount = Integer.parseInt(cleanAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수 형태의 금액을 입력해주세요.");
        }
        LottoValidateUtil.validatePurchaseAmount(parsedAmount);

        return parsedAmount;
    }
}
