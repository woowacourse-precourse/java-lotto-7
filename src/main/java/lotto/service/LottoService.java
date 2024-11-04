package lotto.service;

import lotto.exception.ErrorMessage;
import lotto.exception.ExceptionHandler;
import lotto.model.lotto.LottoStatistics;
import lotto.model.lotto.WinningLotto;
import lotto.model.lotto.lottoCollection;
import lotto.service.util.LottoGenerator;

public class LottoService {
    private static final int UNIT = 1000;
    private LottoStatistics statistics;

    public lottoCollection purchaseLottos(int amount) {
        validatePurchaseAmount(amount);
        int numberOfLottos = amount / UNIT;
        return new lottoCollection(LottoGenerator.generateLottos(numberOfLottos));
    }

    public void calculateResults(lottoCollection lottoCollection, WinningLotto winningLotto) {
        this.statistics = new LottoStatistics();
        statistics.calculate(lottoCollection, winningLotto);
    }

    public LottoStatistics getStatistics() {
        return statistics;
    }

    public double getEarningsRate(int purchaseAmount) {
        return statistics.calculateEarningsRate(purchaseAmount);
    }

    private void validatePurchaseAmount(int amount) {
        if (amount < UNIT) {
            ExceptionHandler.throwIllegalArgException(ErrorMessage.INVALID_PURCHASE_AMOUNT);
        }
        if (amount % UNIT != 0) {
            ExceptionHandler.throwIllegalArgException(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT);
        }
    }
}
