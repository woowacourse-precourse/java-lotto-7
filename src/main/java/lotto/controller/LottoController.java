package lotto.controller;

import lotto.model.lotto.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.result.LottoResult;
import lotto.model.lotto.LottoGenerator;

import java.util.List;

public class LottoController {

    public void run(){

        // 구입 금액 입력
        int PurchaseAmount = InputView.getPurchaseAmount();
        int LottoAmount  = PurchaseAmount/InputView.AmountUnit;
        OutputView.printLottoAmount(LottoAmount);

        // 구매 로또 갯수만큼 번호 생성 및 출력
        List<Lotto> purchasedLottos = LottoGenerator.generateLottos(LottoAmount);
        OutputView.printPurchasedLottos(purchasedLottos);

        // 당첨 로또 번호 입력
        List<Integer> winningNumber = InputView.getWinLottoNumbers();

        //보너스 넘버 입력
        int bonusNumber = InputView.getBonusNumber(winningNumber);

        // 당첨 결과 계산
        LottoResult lottoResult = new LottoResult(purchasedLottos, winningNumber, bonusNumber);
        OutputView.printLottoResult(lottoResult);

        // 수익률 출력
        int totalPrize = LottoResult.getTotalPrize();
        double profitRate = lottoResult.getProfitRate(totalPrize,PurchaseAmount);
        OutputView.printRateOfReturn(profitRate);
    }

}
