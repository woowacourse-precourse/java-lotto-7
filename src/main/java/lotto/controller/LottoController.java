package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoResult;
import lotto.domain.Numbers;
import lotto.factory.LottoMakeFactory;
import lotto.factory.LottoPurchaseFactory;
import lotto.factory.NumbersMakeFactory;
import lotto.messages.WinningMessage;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final LottoResult lottoResult;

    public LottoController() {
        outputView = new OutputView();
        lottoResult = new LottoResult();
    }


    public void run() {
        LottoPurchase lottoPurchase = inputAmount();

        int purchaseAmount = lottoPurchase.getPurchaseAmount();
        OutputView.printPurchaseAmount(purchaseAmount);

        List<Lotto> lottoNumbers = makeLotto(purchaseAmount);
        outputView.printLottoNumbers(lottoNumbers);

        Numbers numbers = getNumbers();
        lottoResult.calculateWinningResult(lottoNumbers, numbers);

        Map<WinningMessage, Integer> winningResult = lottoResult.getWinningResults();
        outputView.printWinningResult(winningResult);


    }

    private List<Lotto> makeLotto(int purchaseAmount) {
        return LottoMakeFactory.makeTickets(purchaseAmount);
    }

    private LottoPurchase inputAmount() {
        return LottoPurchaseFactory.createLottoPurchase();
    }

    private Numbers getNumbers() {
        return NumbersMakeFactory.getNumbers();
    }
}
