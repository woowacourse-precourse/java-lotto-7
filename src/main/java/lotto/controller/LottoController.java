package lotto.controller;

import lotto.model.lotto.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.lotto.LottoGenerator;

import java.util.List;

public class LottoController {

    public void run(){
        // 구입 금액 입력
        int PurchaseAmount = InputView.getPurchaseAmount();

        // 구매 로또 갯수 출력
        int LottoAmount  = PurchaseAmount/InputView.AmountUnit;
        OutputView.printLottoAmount(LottoAmount);

        List<Lotto> purchasedLottos = LottoGenerator.generateLottos(LottoAmount);
        OutputView.printPurchasedLottos(purchasedLottos);

        // 당첨 로또 번호 입력
        List<Integer> WinningNumber = InputView.getWinLottoNumbers();
        Lotto winningLotto = new Lotto(WinningNumber);

        //보너스 금액 입력
        int bonusNumber = InputView.getBonusNumber();
    }

}
