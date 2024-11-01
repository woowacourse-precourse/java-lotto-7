package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private LottoOutputView lottoOutputView;
    private LottoInputView lottoInputView;

    public LottoController(LottoOutputView lottoOutputView, LottoInputView lottoInputView) {
        this.lottoOutputView = lottoOutputView;
        this.lottoInputView = lottoInputView;
    }

    public void run() {
        int lottoAmount = lottoInputView.inputPurchaseAmount();
        int numberOfTickets = lottoOutputView.outputNumberOfLottoOutput(lottoAmount);
        lottoOutputView.outputMakeRandomLottos(numberOfTickets);

        Lotto winningNumbers = lottoInputView.inputWinningNumbers();
        List<Integer> winningNumberList = winningNumbers.lottoNumbers();

        int bonusNumber = lottoInputView.inputBonusNumber();
    }
}
