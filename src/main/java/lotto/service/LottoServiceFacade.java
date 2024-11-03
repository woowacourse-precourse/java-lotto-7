package lotto.service;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class LottoServiceFacade {

    private final LottoNumberService lottoNumberService;
    private final CalculateService calculateService;

    public LottoServiceFacade(LottoNumberService lottoNumberService, CalculateService calculateService) {
        this.lottoNumberService = lottoNumberService;
        this.calculateService = calculateService;
    }

    public void purchaseLotto(int purchaseAmount) {
        lottoNumberService.purchaseLotto(purchaseAmount);
    }

    public List<Lotto> getPurchasedLottos() {
        return lottoNumberService.getPurchasedLotto().getPurchasedLottos();
    }

    public void setWinningNumbers(List<Integer> winningNumbers) throws IllegalArgumentException {
        lottoNumberService.setWinningNumbers(winningNumbers);
    }

    public void validateBonusNumber(int bonusNumber) throws IllegalArgumentException {
        lottoNumberService.validateBonusNumber(bonusNumber);
    }

    public void createWinningLotto(int bonusNumber) {
        lottoNumberService.createWinningLotto(bonusNumber);
    }

    public void calculateResults(int purchaseAmount) {
        calculateService.calculateWinning(
                lottoNumberService.getPurchasedLotto(),
                lottoNumberService.getWinningLotto()
        );
        calculateService.calculateProfitRate(purchaseAmount);
    }

    public EnumMap<LottoRank, Integer> getWinningStatistics() {
        return calculateService.getWinningLottos();
    }

    public double getProfitRate() {
        return calculateService.getProfitRate();
    }
}
