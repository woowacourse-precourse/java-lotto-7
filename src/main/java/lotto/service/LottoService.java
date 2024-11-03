package lotto.service;

import java.util.List;
import lotto.model.handler.PurchaseRequestHandler;
import lotto.model.handler.WinningNumbersAndBonusNumberRequestHandler;
import lotto.model.lotto.LottoResult;
import lotto.model.lotto.Lottos;
import lotto.model.winning.WinningNumbersAndBonusNumber;
import lotto.model.rank.RankResult;

public class LottoService {
    private final PurchaseRequestHandler purchaseRequestHandler;
    private final WinningNumbersAndBonusNumberRequestHandler winningNumbersAndBonusNumberRequestHandler;

    public LottoService(PurchaseRequestHandler purchaseRequestHandler,
                        WinningNumbersAndBonusNumberRequestHandler winningNumbersAndBonusNumberRequestHandler) {
        this.purchaseRequestHandler = purchaseRequestHandler;
        this.winningNumbersAndBonusNumberRequestHandler = winningNumbersAndBonusNumberRequestHandler;
    }

    public int getPurchaseCount(String amount) {
        return purchaseRequestHandler.getPurchaseAmount(amount);
    }

    public List<Integer> getWinningNumbers(List<String> lottoInput) {
        return winningNumbersAndBonusNumberRequestHandler.getWinningNumbers(lottoInput);
    }

    public int getBonusNumber(String bonusInput, List<Integer> winningNumbers) {
        return winningNumbersAndBonusNumberRequestHandler.getBonusNumber(bonusInput, winningNumbers);
    }

    public Lottos generateLottos(int count) {
        return Lottos.generate(count);
    }

    public LottoResultChecker createResultChecker(WinningNumbersAndBonusNumber winningNumbersAndBonusNumber) {
        return new LottoResultChecker(winningNumbersAndBonusNumber);
    }

    public RankResult checkRanks(List<LottoResult> lottoResults) {
        RankChecker rankChecker = new RankChecker();
        return rankChecker.check(lottoResults);
    }

    public double calculateTotalPrize(RankResult rankResult) {
        PrizeCalculator prizeCalculator = new PrizeCalculator();
        return prizeCalculator.calculate(rankResult);
    }

    public double calculateRateOfReturn(int count, double totalPrize) {
        RateOfReturnCalculator rateOfReturnCalculator = new RateOfReturnCalculator();
        return rateOfReturnCalculator.calculate(count, totalPrize);
    }

}
