package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.function.Supplier;
import lotto.domain.LottoResult;
import lotto.domain.Numbers;
import lotto.domain.Number;
import lotto.domain.Price;
import lotto.service.PurchaseService;
import lotto.service.ResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    PurchaseService purchaseService;
    ResultService resultService;

    Price purchasePrice;
    Numbers winNumbers;
    Number bonusNumber;

    public LottoController() {
        purchaseService = new PurchaseService(new ArrayList<>());
        resultService = new ResultService(new LottoResult());
    }

    public void run() {
        purchase();
        winInformation();
        Console.close();
        result();
    }

    private void purchase() {
        purchasePrice = executeWithRetry(
            () -> purchaseService.getPurchasePrice(InputView.inputPurchasePrice())
        );

        OutputView.printPurchasedLottoAmount(purchasePrice.getLottoAmount());

        purchaseService.purchaseLotto(purchasePrice);

        OutputView.printPurchasedLottoNumbers(purchaseService.getPurchasedLotteries());
    }

    private void winInformation() {
        winNumbers = executeWithRetry(
            () -> resultService.getWinNumbers(InputView.inputWinNumbers())
        );

        bonusNumber = executeWithRetry(
            () -> resultService.getBonusNumber(winNumbers, InputView.inputBonusNumber())
        );
    }

    private void result() {
        resultService.calculateLottoResult(purchaseService.getPurchasedLotteries(), winNumbers, bonusNumber);

        OutputView.printWinStatistics();

        resultService.getLottoResult().forEach((result, count) -> {
            OutputView.printWinStatisticsDetail(result.getMessage(), count);
        });

        OutputView.printProfitRate(resultService.getProfitRate(purchasePrice));
    }

    private <T> T executeWithRetry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
