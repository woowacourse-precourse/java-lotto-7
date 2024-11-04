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
import java.util.function.Supplier;

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
        return validateInput(() -> lottoService.getPurchaseAmount(InputView.getPurchaseAmount()));
    }

    private Lotto getWinningNumbers() {
        return validateInput(() -> lottoService.createWinningLotto(InputView.getWinningNumbers()));
    }

    private int getBonusNumber() {
        return validateInput(() -> lottoService.getBonusNumber(InputView.getBonusNumber()));
    }

    private void printPrize(Map<LottoWinnerPrize, Integer> prizeCount) {
        OutputView.promptWINNING_STATISTICS();
        lottoService.getPrizeList(prizeCount)
                .forEach(prize -> OutputView.printPrizeCount(prize.getDescription(), prizeCount.get(prize)));
    }

    private <T> T validateInput(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
