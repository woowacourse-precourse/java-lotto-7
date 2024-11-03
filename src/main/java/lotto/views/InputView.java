package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Messages;

public class InputView extends LottoView {

    public void requestPurchaseAmount() {
        displayMessage(Messages.INPUT_PURCHASE_AMOUNT);
    }

    public void requestWinningNumbers() {
        System.out.println();
        displayMessage(Messages.INPUT_WINNING_NUMBERS);
    }

    public void requestBonusNumber() {
        System.out.println();
        displayMessage(Messages.INPUT_BONUS_NUMBER);
    }

}
