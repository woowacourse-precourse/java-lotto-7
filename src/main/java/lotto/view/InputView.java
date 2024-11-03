package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.InputParser;
import lotto.util.InputValidator;

public class InputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public static int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return readValidatedInteger();
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        String winningNumbers = Console.readLine().trim();
        InputValidator.validateWinningNumbers(winningNumbers);
        return InputParser.parseToNumbers(winningNumbers);
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return readValidatedInteger();
    }

    private static int readValidatedInteger() {
        String input = Console.readLine().trim();
        InputValidator.validateNotBlankAndInteger(input);
        return Integer.parseInt(input);
    }
}
