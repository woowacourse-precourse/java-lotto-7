package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.utils.InputHandler;

public class InputView {

    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        return InputHandler.handleMoneyInput(input());
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
        return InputHandler.handleWinningNumbersInput(input());
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return InputHandler.handleBonusNumberInput(input());
    }

    private static String input() {
        return Console.readLine().trim();
    }
}
