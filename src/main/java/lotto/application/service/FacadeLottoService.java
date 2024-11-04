package lotto.application.service;

import java.util.List;
import lotto.application.CalculateProfitUseCase;
import lotto.application.LottoResultUseCase;
import lotto.application.FacadeLottoUseCase;
import lotto.application.PurchaseLottoUseCase;
import lotto.application.RetrieveLottoUseCase;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinResult;

public class FacadeLottoService implements FacadeLottoUseCase {

    private final PurchaseLottoUseCase purchaseLottoUseCase;
    private final RetrieveLottoUseCase retrieveLottoUseCase;
    private final LottoResultUseCase lottoResultUseCase;
    private final CalculateProfitUseCase calculateProfitUseCase;

    public FacadeLottoService(
            PurchaseLottoUseCase purchaseLottoUseCase,
            RetrieveLottoUseCase retrieveLottoUseCase,
            LottoResultUseCase lottoResultUseCase,
            CalculateProfitUseCase calculateProfitUseCase
    ) {
        this.purchaseLottoUseCase = purchaseLottoUseCase;
        this.retrieveLottoUseCase = retrieveLottoUseCase;
        this.lottoResultUseCase = lottoResultUseCase;
        this.calculateProfitUseCase = calculateProfitUseCase;
    }

    @Override
    public void purchase(Money money) {
        purchaseLottoUseCase.purchase(money);
    }

    @Override
    public List<Lotto> retrieveAll() {
        return retrieveLottoUseCase.retrieveAll();
    }

    @Override
    public void createWinLotto(List<Integer> numbers, int bonusNumber) {
        lottoResultUseCase.createWinLotto(numbers, bonusNumber);
    }

    @Override
    public void checkWinning() {
        lottoResultUseCase.checkWinning();
    }

    @Override
    public WinResult getWinResult() {
        return lottoResultUseCase.getWinResult();
    }

    @Override
    public float calculateProfitRate() {
        return calculateProfitUseCase.calculateRate();
    }
}
