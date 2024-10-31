package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String INPUT_BUDGET_INFO= "구입금액을 입력해 주세요.";
    private static final String ERROR_BUDGET_NUMBER_FORMAT = "[ERROR] 금액은 숫자로 입력해주세요.";
    private static final String ERROR_BUDGET_NEGATIVE_NUMBER = "[ERROR] 금액은 음수일 수 없습니다.";
    private static final String ERROR_BUDGET_INVALID_UNIT = "[ERROR] 금액은 1000원 단위여야 합니다.";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Long budget = readBudget();

    }

    private static Long readBudget() {
        System.out.println(INPUT_BUDGET_INFO);
        String input = Console.readLine();
        try {
            Long budget = Long.parseLong(input);
            validateBudgetSign(budget);
            validateBudgetUnit(budget);
            return budget;
        } catch (NumberFormatException e) {
            System.out.println(ERROR_BUDGET_NUMBER_FORMAT);
            return readBudget();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBudget();
        }
    }

    private static void validateBudgetSign(Long budget) {
        if (budget < 0) {
            throw new IllegalArgumentException(ERROR_BUDGET_NEGATIVE_NUMBER);
        }
    }
    private static void validateBudgetUnit(Long budget) {
        if (budget % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_BUDGET_INVALID_UNIT);
        }
    }
}
