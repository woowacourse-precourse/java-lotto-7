package lotto.validation;

import lotto.LottoPrice;

public class InputValidation {
    public static void validateBudget(String budgetInput) {
        if (!budgetInput.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR]구입 금액은 숫자로만 입력해 주세요.");
        }

        int budget = Integer.parseInt(budgetInput);

        if (budget % LottoPrice.TICKET_PRICE.getPrice() != 0) {
            throw new IllegalArgumentException("[ERROR]정확한 금액을 입력해 주세요.");
        }
    }
}
