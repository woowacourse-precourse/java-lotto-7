package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.domain.Numbers;
import lotto.domain.Number;
import lotto.domain.Price;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        Price purchasePrice = getPurchasePrice();
        OutputView.printPurchasedLottoAmount(purchasePrice.getLottoAmount());

        List<Lotto> purchasedLottos = getPurchasedLottos(purchasePrice);
        OutputView.printPurchasedLottoNumbers(purchasedLottos);

        Numbers winNumbers = getWinNumbers();
        Number bonusNumber = getBonusNumber(winNumbers);

        LottoResult lottoResult = new LottoResult();
        calculateLottoResult(lottoResult, purchasedLottos, winNumbers, bonusNumber);
        calculateProfitRate(lottoResult, purchasePrice);

        OutputView.printWinStatistics();

        lottoResult.getLottoResult().forEach((result, count) -> {
            OutputView.printWinStatisticsDetail(result.getMessage(), count);
        });

        OutputView.printProfitRate(lottoResult.getProfitRate());
    }

    private Price getPurchasePrice() {
        while (true) {
            try {
                return new Price(InputView.inputPurchasePrice());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> getPurchasedLottos(Price price) {
        LottoStore lottoStore = new LottoStore();
        while (true) {
            try {
                return lottoStore.buyLotto(price.getLottoAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Numbers getWinNumbers() {
        while (true) {
            try {
                return new Numbers(InputView.inputWinNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Number getBonusNumber(Numbers winNumbers) {
        while (true) {
            try {
                Number bonusNumber = new Number(InputView.inputBonusNumber());
                Number.validateBonusNumber(winNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void calculateLottoResult(LottoResult lottoResult, List<Lotto> lottos, Numbers winNumbers, Number bonusNumber) {
        lottoResult.calculateLottoResult(lottos, winNumbers, bonusNumber);
    }

    private void calculateProfitRate(LottoResult lottoResult, Price purchasePrice) {
        lottoResult.calculateProfitRate(purchasePrice);
    }
}
