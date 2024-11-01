package lotto.controller;


import java.util.List;
import java.util.function.Predicate;
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
        try {
            return new Price(InputView.inputPurchasePrice());
        } catch (IllegalArgumentException e) {
            getPurchasePrice();
        }
        return null;
    }

    private List<Lotto> getPurchasedLottos(Price price) {
        LottoStore lottoStore = new LottoStore();
        try {
            return lottoStore.buyLotto(price.getLottoAmount());
        } catch (IllegalArgumentException e) {
            getPurchasedLottos(price);
        }
        return null;
    }

    private Numbers getWinNumbers() {
        try {
            return new Numbers(InputView.inputWinNumbers());
        } catch (IllegalArgumentException e) {
            getWinNumbers();
        }
        return null;
    }

    private Number getBonusNumber(Numbers winNumbers) {
        try {
            Number bonusNumber = new Number(InputView.inputBonusNumber());
            if (winNumbers.contains(bonusNumber)) throw new IllegalArgumentException();
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            getBonusNumber(winNumbers);
        }
        return null;
    }

    private void calculateLottoResult(LottoResult lottoResult, List<Lotto> lottos, Numbers winNumbers, Number bonusNumber) {
        lottoResult.calculateLottoResult(lottos, winNumbers, bonusNumber);
    }

    private void calculateProfitRate(LottoResult lottoResult, Price purchasePrice) {
        lottoResult.calculateProfitRate(purchasePrice);
    }
}
