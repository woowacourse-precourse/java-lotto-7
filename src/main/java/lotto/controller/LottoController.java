package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.function.Supplier;
import lotto.domain.LottoResult;
import lotto.domain.Numbers;
import lotto.domain.Number;
import lotto.domain.Price;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    LottoService lottoService;
    LottoResult lottoResult;

    Price purchasePrice;
    Numbers winNumbers;
    Number bonusNumber;

    public LottoController() {
        lottoService = new LottoService(new ArrayList<>());
        lottoResult = new LottoResult();
    }

    public void run() {
        purchase();
        winInformation();
        Console.close();
        result();
    }

    private void purchase() {
        purchasePrice = executeWithRetry(
            () -> lottoService.getPurchasePrice(InputView.inputPurchasePrice())
        );

        OutputView.printPurchasedLottoAmount(purchasePrice.getLottoAmount());

        lottoService.purchaseLotto(purchasePrice);

        OutputView.printPurchasedLottoNumbers(lottoService.getPurchasedLotteries());
    }

    private void winInformation() {
        winNumbers = executeWithRetry(
            () -> lottoService.getWinNumbers(InputView.inputWinNumbers())
        );

        bonusNumber = executeWithRetry(
            () -> lottoService.getBonusNumber(winNumbers, InputView.inputBonusNumber())
        );
    }

    private void result() {
        lottoResult.calculateLottoResult(lottoService.getPurchasedLotteries(), winNumbers, bonusNumber);

        OutputView.printWinStatistics();

        lottoResult.getDetail().forEach((result, count) -> {
            OutputView.printWinStatisticsDetail(result.getMessage(), count);
        });

        OutputView.printProfitRate(lottoResult.getProfitRate(purchasePrice));
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
