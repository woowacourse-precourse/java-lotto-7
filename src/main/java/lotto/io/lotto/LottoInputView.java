package lotto.io.lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.lotto.LottoConstant;

public class LottoInputView {

    private final LottoOutputView lottoOutputView;

    public LottoInputView(LottoOutputView lottoOutputView) {
        this.lottoOutputView = lottoOutputView;
    }

    public String inputPurchaseAmount() {
        lottoOutputView.printMessage(LottoConstant.INPUT_PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        lottoOutputView.printEnterAndMessage(LottoConstant.INPUT_WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        lottoOutputView.printEnterAndMessage(LottoConstant.INPUT_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
