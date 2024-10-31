package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoMaker;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoMaker lottoMaker = new LottoMaker();

    public void run() {
        List<Lotto> lottos = purchaseLotto();
        outputView.printPurchasedLottos(lottos);

        List<Integer> winningNumbers = inputView.inputWinningNumbers();
    }

    public List<Lotto> purchaseLotto() {
        try {
            int purchaseMoney = inputView.inputPurchaseMoney();
            return lottoMaker.makeLottos(purchaseMoney);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return purchaseLotto();
        }
    }
}
