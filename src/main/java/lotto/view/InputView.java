package lotto.view;

import static lotto.message.GuideMessage.*;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.GuideMessage;

public class InputView {

    public String readRawPurchaseAmount() {
        printGuideMessage(PURCHASE_AMOUNT_REQUEST_MESSAGE);
        String rawPurchaseAmount = Console.readLine();
        return rawPurchaseAmount.trim();
    }

    public String readRawWinningNumbers() {
        printNewLine();
        printGuideMessage(WINNING_NUMBER_REQUEST_MESSAGE);
        String rawWinningNumbers = Console.readLine();
        return rawWinningNumbers.trim();
    }

    public String readRawBonusNumber() {
        printNewLine();
        printGuideMessage(BONUS_NUMBER_REQUEST_MESSAGE);
        String rawBonusNumber = Console.readLine();
        return rawBonusNumber.trim();
    }

    public void close() {
        Console.close();
    }

    private void printGuideMessage(GuideMessage guideMessage) {
        System.out.println(guideMessage.getContent());
    }

    private void printNewLine() {
        System.out.println();
    }
}
