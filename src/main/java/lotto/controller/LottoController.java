package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.Numbers;
import lotto.factory.LottoMakeFactory;
import lotto.factory.LottoPurchaseFactory;
import lotto.factory.NumbersMakeFactory;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;

    public LottoController() {
        outputView = new OutputView();
    }

    public void run() {
        LottoPurchase lottoPurchase = inputAmount();

        int purchaseAmount = lottoPurchase.getPurchaseAmount();
        OutputView.printPurchaseAmount(purchaseAmount);

        List<Lotto> lottoNumbers = makeLotto(purchaseAmount);
        outputView.printLottoNumbers(lottoNumbers);

        Numbers numbers = getNumbers();
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
