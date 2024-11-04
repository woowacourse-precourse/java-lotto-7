package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidator;

public class InputView {

    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String requestMoneyInput() {
        System.out.println(MONEY_INPUT_MESSAGE);

        String moneyInput = Console.readLine();
        InputValidator.validateNotEmpty(moneyInput);

        return moneyInput;
    }

    public String requestWinningNumbersInput() {
        System.out.println(System.lineSeparator() + WINNING_NUMBERS_INPUT_MESSAGE);

        String winningNumbersInput = Console.readLine();
        InputValidator.validateNotEmpty(winningNumbersInput);

        return winningNumbersInput;
    }

    public String requestBonusNumberInput() {
        System.out.println(System.lineSeparator() + BONUS_NUMBER_INPUT_MESSAGE);

        String bonusNumberInput = Console.readLine();
        InputValidator.validateNotEmpty(bonusNumberInput);

        return bonusNumberInput;
    }
}
