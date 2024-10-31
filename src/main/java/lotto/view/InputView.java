package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

public class InputView {
    private final static String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private final InputHandler inputHandler;

    public InputView(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public PurchaseAmount readPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        final String input = Console.readLine();
        final int validateNumber = inputHandler.validateNumber(input);
        return new PurchaseAmount(validateNumber);
    }

    public WinningNumbers readWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        final String input = Console.readLine();
        inputHandler.checkNull(input);
        List<Integer> numbers = inputHandler.parsedNumbers(input);
        for (Integer number : numbers) {
            inputHandler.checkNumberRange(number);
        }
        return new WinningNumbers(numbers);
    }

//    public void readBonusNumber() {
//        System.out.println(INPUT_BONUS_NUMBER);
//    }
}
