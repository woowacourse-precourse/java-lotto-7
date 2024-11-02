package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoPurchaseAmount;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.view.InputView.readInput;


public class LottoController {

    public void run() {
        InputView.printPurchaseAmountPrompt();
        int purchaseAmount = LottoPurchaseAmount.from(readInput()).getPurchaseAmount();

        int lottoCount = LottoCount.from(purchaseAmount).getLottoCount();
        List<Lotto> lottos = Lottos.from(lottoCount).getLottos();
        OutputView.printLottoPurchaseCount(lottoCount);
        OutputView.printLottoListPrompt(lottos);

    }

}