package lotto.io.request;

import lotto.domain.Lottos;
import lotto.util.ExceptionMessages;

public record BudgetRequest(String budget) {
    private static final String NUMBER_PATTERN = "\\d+";

    public BudgetRequest {
        validateEmpty(budget);
        validateNumber(budget);
        Lottos lottos = Lottos.from(Integer.parseInt(budget));
    }

    private void validateEmpty(String number) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.EMPTY_INPUT.getMessage());
        }
    }

    private void validateNumber(String number) {
        if (!number.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CHARACTER.getMessage());
        }
    }
}
