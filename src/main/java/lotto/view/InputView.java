package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.InputParser;
import lotto.util.InputValidator;

public class InputView {

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readValidatedInteger();
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine().trim();
        InputValidator.validateWinningNumbers(winningNumbers);
        return InputParser.parseToNumbers(winningNumbers);
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return readValidatedInteger();
    }

    private static int readValidatedInteger() {
        String input = Console.readLine().trim();
        InputValidator.validateNotBlankAndInteger(input);
        return Integer.parseInt(input);
    }
}
