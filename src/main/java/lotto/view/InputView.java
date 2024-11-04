package lotto.view;

import lotto.util.common.CommonIo;
import lotto.util.common.Message;

public class InputView {
    private final CommonIo io;

    public InputView(CommonIo io) {
        this.io = io;
    }

    public void printRequestPurchase() {
        io.printMessage(Message.REQUEST_MONEY_INPUT.getSentence());
    }

    public void printRequestWinningNumbers() {
        io.printMessage(Message.REQUEST_WINNING_NUMBER_INPUT.getSentence());
    }

    public void printRequestBonusNumber() {
        io.printMessage(Message.REQUEST_BONUS_NUMBER_INPUT.getSentence());
    }

}
