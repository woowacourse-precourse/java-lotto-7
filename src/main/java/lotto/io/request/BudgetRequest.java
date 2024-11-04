package lotto.io.request;

import lotto.domain.Lottos;
import lotto.util.ExceptionMessages;

public record BudgetRequest(String budget) {
    private static final String NUMBER_PATTERN = "\\d+";

    public BudgetRequest {
        validateEmpty(budget);
        validateNumber(budget);
        //validateLottos(budget);
    }

    private void validateEmpty(String budget) {
        if (budget == null || budget.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.EMPTY_INPUT.getMessage());
        }
    }

    private void validateNumber(String budget) {
        if (!budget.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CHARACTER.getMessage());
        }
    }

    private void validateLottos(String budget) {
        Lottos lottos = Lottos.from(Integer.parseInt(budget));
    }
}
