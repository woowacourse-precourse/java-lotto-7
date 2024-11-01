package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_BUDGET_INFO = "구입금액을 입력해 주세요.";
    private static final String ERROR_BUDGET_NUMBER_FORMAT = "[ERROR] 금액은 숫자로 입력해주세요.";

    public Budget readBudget() {
        String input = promptForBudget();
        return makeBudget(input);
    }

    private String promptForBudget() {
        System.out.println(INPUT_BUDGET_INFO);
        return Console.readLine();
    }

    private Budget makeBudget(String input) {
        try {
            Long amount = Long.parseLong(input);
            return Budget.of(amount);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_BUDGET_NUMBER_FORMAT);
            return readBudget();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBudget();
        }
    }

}
