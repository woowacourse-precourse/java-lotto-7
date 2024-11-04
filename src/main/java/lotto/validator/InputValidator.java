package lotto.validator;

import lotto.config.LottoGameConfig;

public class InputValidator {
    public void validateEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백으로 입력되었습니다.");
        }
    }

    public int validateAndParseNumber(String input) {
        int number = 0;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }

        return number;
    }

    public void validatePurchaseAmount(int money) {
        if (money < LottoGameConfig.PURCHASE_PRICE) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 구입 금액은 " + LottoGameConfig.PURCHASE_PRICE + "원 이상이어야 합니다.");
        }
        if (money % LottoGameConfig.PURCHASE_PRICE != 0) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 구입 금액은 " + LottoGameConfig.PURCHASE_PRICE + " 단위로 입력해야 합니다.");
        }
    }

}
