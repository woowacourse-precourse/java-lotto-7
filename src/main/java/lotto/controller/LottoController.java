package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.view.InputView;

import java.util.List;

public class LottoController {

    LottoMachine lottoMachine;

    public void run() {
        long purchaseAmount = InputView.inputPurchaseAmount();
//        int[] winningNumbers = InputView.inputWinningNumbers();
//        int bonusNumber = InputView.inputBonusNumber();

        lottoMachine = new LottoMachine();
        lottoMachine.start(purchaseAmount);
        List<Lotto> lottos = lottoMachine.getLottos();
        int lotteryCnt = lottoMachine.getLotteryCnt();

    }
}
