package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoGame {
    private final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void run() {

    }

    public int purchaseAmount() {
        println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        try {
            return inputPurchaseAmount();
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
            return purchaseAmount();
        }
    }
}
