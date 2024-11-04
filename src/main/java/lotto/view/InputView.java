package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.validator.BonusValidator;
import lotto.util.validator.BudgetValidator;
import lotto.util.validator.WinningNumberValidator;

public class InputView {
    private static final String INPUT_BUDGET = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public int readBudget() {
        System.out.println(INPUT_BUDGET);
        String input = Console.readLine();
        BudgetValidator budgetValidator = new BudgetValidator();
        return budgetValidator.validate(input);
    }

    public List<Integer> readWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        String input = Console.readLine();
        WinningNumberValidator validator = new WinningNumberValidator();
        return validator.validate(input);
    }

    public int readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String input = Console.readLine();
        BonusValidator validator = new BonusValidator();
        return validator.validate(input);
    }
}