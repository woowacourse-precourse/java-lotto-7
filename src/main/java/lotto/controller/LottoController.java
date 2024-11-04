package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.LottoWinnerPrize;
import lotto.model.PurchasedLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        int lottoQuantity = lottoService.calculateLottoQuantity(purchaseAmount);
        OutputView.printPurchaseAmount(lottoQuantity);

        PurchasedLotto purchasedLotto = lottoService.createPurchasedLotto(lottoQuantity);
        OutputView.printPurchasedLottos(purchasedLotto.getLottos());

        LottoManager lottoManager = lottoService.createLottoManager(getWinningNumbers(), getBonusNumber());
        Map<LottoWinnerPrize, Integer> prizeCount = lottoManager.getWinningPrizes(purchasedLotto.getLottos());
        printPrize(prizeCount);

        double rateOfReturn = lottoService.getRateOfReturn(prizeCount, purchaseAmount);
        OutputView.printRateOfReturn(rateOfReturn);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                return lottoService.getPurchaseAmount(InputView.getPurchaseAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getWinningNumbers() {
        while (true) {
            try {
                return lottoService.createWinningLotto(InputView.getWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                return lottoService.getBonusNumber(InputView.getBonusNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printPrize(Map<LottoWinnerPrize, Integer> prizeCount) {
        OutputView.promptWINNING_STATISTICS();
        List<LottoWinnerPrize> result = lottoService.getPrizeList(prizeCount);
        for (LottoWinnerPrize prize : result) {
            OutputView.printPrizeCount(prize.getDescription(), prizeCount.get(prize));
        }
    }

}
