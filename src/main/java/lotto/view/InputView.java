package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;
import java.util.List;

public class InputView {
    private static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    public int readPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT);
        String input = Console.readLine();
        return InputValidator.parsePositiveNumber(input);
    }

    public List<Integer> readWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS);
        String input = Console.readLine();
        return InputValidator.parseNumbers(input);
    }

    public int readBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        String input = Console.readLine();
        return InputValidator.parsePositiveNumber(input);
    }
}