package lotto.controller;

import java.util.List;
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
        List<Integer> winningNumbers = lottoInputView.inputWinningNumbers();
        int bonusNumber = lottoInputView.inputBonusNumber();
        // 테스트 삭제예정
        System.out.println("winningNumbers : " + winningNumbers);
        System.out.println("bonustNumber = " + bonusNumber);
        // 테스트 삭제예정
    }
}
