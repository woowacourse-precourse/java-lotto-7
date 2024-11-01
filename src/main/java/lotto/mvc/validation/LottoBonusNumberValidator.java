package lotto.mvc.validation;

import lotto.mvc.model.Lotto;

public class LottoBonusNumberValidator {
    public static void isValid(Lotto lotto, String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액을 입력하셔야 합니다.");
        }

        try {
            int number = Integer.parseInt(input);

            if (number <= 0) {
                throw new IllegalArgumentException("[ERROR] 로또 구매 금액을 입력하셔야 합니다.");
            }

            if (number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 구매 금액을 입력하셔야 합니다.");
            }

            if (lotto.getNumbers().contains(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 구매 금액을 입력하셔야 합니다.");
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액을 입력하셔야 합니다.");
        }
    }
}
