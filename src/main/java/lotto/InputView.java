package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_BUDGET_INFO= "구입금액을 입력해 주세요.";
    private static final String ERROR_BUDGET_NUMBER_FORMAT = "[ERROR] 금액은 숫자로 입력해주세요.";
    private static final String ERROR_BUDGET_NEGATIVE_NUMBER = "[ERROR] 금액은 음수일 수 없습니다.";
    private static final String ERROR_BUDGET_INVALID_UNIT = "[ERROR] 금액은 1000원 단위여야 합니다.";
    private static final long LOTTO_PRICE = 1000;

    public Long readBudget() {
        String input = promptForBudget();
        return makeBudget(input);
    }

    private String promptForBudget() {
        System.out.println(INPUT_BUDGET_INFO);
        return Console.readLine();
    }

    private Long makeBudget(String input) {
        try {
            Long budget = Long.parseLong(input);
            validate(budget);
            return budget;
        } catch (NumberFormatException e) {
            System.out.println(ERROR_BUDGET_NUMBER_FORMAT);
            return readBudget();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBudget();
        }
    }

    private void validate(Long budget) {
        validateBudgetSign(budget);
        validateBudgetUnit(budget);
    }

    private void validateBudgetSign(Long budget) {
        if (budget < 0) {
            throw new IllegalArgumentException(ERROR_BUDGET_NEGATIVE_NUMBER);
        }
    }

    private void validateBudgetUnit(Long budget) {
        if (budget % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_BUDGET_INVALID_UNIT);
        }
    }
}
