package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoResultCalculator;
import lotto.model.PurchaseAmount;
import lotto.model.WinningLotto;
import lotto.model.WinningStatus;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();

        List<Lotto> lottos = purchaseLottos(purchaseAmount);
        printPurchaseLottos(lottos);

        WinningLotto winningLotto = getWinningLotto();

        outputView.printResult(getLottoResult(winningLotto, lottos));
    }

    private PurchaseAmount getPurchaseAmount() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputView.requestPurchaseAmount());
        outputView.printPurchaseAmount(purchaseAmount.getLottoQuantity());
        return purchaseAmount;
    }

    private List<Lotto> purchaseLottos(PurchaseAmount purchaseAmount) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return lottoGenerator.generateLottos(purchaseAmount.getLottoQuantity());
    }

    private void printPurchaseLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            outputView.printLottoNumbers(lotto.getNumbers());
        }
        outputView.printEnter();
    }

    private WinningLotto getWinningLotto() {
        Lotto lotto = new Lotto(Parser.parseStringToList(inputView.requestWinningNumbers()));
        BonusNumber bonusNumber = new BonusNumber(Parser.parseStringToInt(inputView.requestBonusNumber()));
        return new WinningLotto(lotto, bonusNumber);
    }

    private Map<WinningStatus, Integer> getLottoResult(WinningLotto winningLotto, List<Lotto> lottos) {
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();
        return lottoResultCalculator.calculateLottoResult(winningLotto, lottos).getResult();
    }
}
