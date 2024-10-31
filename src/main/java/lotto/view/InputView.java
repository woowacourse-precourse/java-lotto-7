package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

public class InputView {
    private final static String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String INPUT_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    private final InputHandler inputHandler;

    public InputView(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public PurchaseAmount readPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        final String input = Console.readLine();
        final int number = inputHandler.validateNumber(input);
        return new PurchaseAmount(number);
    }

    public WinningNumbers readWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        final String input = Console.readLine();
        inputHandler.checkNull(input);
        final List<Integer> numbers = inputHandler.parsedNumbers(input);
        for (final Integer number : numbers) {
            inputHandler.checkNumberRange(number);
        }
        return new WinningNumbers(numbers);
    }

    public int readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        final String input = Console.readLine();
        final int number = inputHandler.validateNumber(input);
        inputHandler.checkNumberRange(number);
        return number;
    }
}
