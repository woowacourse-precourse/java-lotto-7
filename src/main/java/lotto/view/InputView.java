package lotto.view;

import static lotto.message.RequestMessage.*;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.RequestMessage;

public class InputView {

    public String readRawPurchaseAmount() {
        printRequestMessage(PURCHASE_AMOUNT_REQUEST_MESSAGE);
        String rawPurchaseAmount = Console.readLine();
        return rawPurchaseAmount.trim();
    }

    public String readRawWinningNumbers() {
        printNewLine();
        printRequestMessage(WINNING_NUMBER_REQUEST_MESSAGE);
        String rawWinningNumbers = Console.readLine();
        return rawWinningNumbers.trim();
    }

    public String readRawBonusNumber() {
        printNewLine();
        printRequestMessage(BONUS_NUMBER_REQUEST_MESSAGE);
        String rawBonusNumber = Console.readLine();
        return rawBonusNumber.trim();
    }

    private void printRequestMessage(RequestMessage requestMessage) {
        System.out.println(requestMessage.getContent());
    }

    private void printNewLine() {
        System.out.println();
    }
}
