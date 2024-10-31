package lotto.view;

import static lotto.validate.PurchaseAmountValidator.getValidatedPurchaseAmount;
import static lotto.validate.WinningNumbersValidator.getValidatedWinningNumbers;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class ConsoleInputView implements InputView {

    @Override
    public int readPurchaseAmount() {
        try {
            Message.PURCHASE_INPUT.display();
            String purchaseAmount = Console.readLine();
            return getValidatedPurchaseAmount(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPurchaseAmount();
        }
    }

    @Override
    public List<Integer> readWinningNumbers() {
        try {
            Message.WINNING_NUMBERS_INPUT.display();
            String winningNumbers = Console.readLine();
            return getValidatedWinningNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWinningNumbers();
        }
    }

    @Override
    public void readBonusNumber() {

    }

    private enum Message {
        PURCHASE_INPUT("구입 금액을 입력해 주세요."),
        WINNING_NUMBERS_INPUT("당첨 번호를 입력해 주세요.")
        ;

        private final String message;

        Message(String message) {
            this.message = message;
        }

        private void display() {
            System.out.println(message + System.lineSeparator());
        }
    }
}
