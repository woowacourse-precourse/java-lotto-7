package lotto.service;

import java.util.List;
import lotto.model.handler.PurchaseRequestHandler;
import lotto.model.handler.WinningNumbersRequestHandler;
import lotto.model.lotto.LottoResult;
import lotto.model.lotto.Lottos;
import lotto.model.winning.WinningNumbers;
import lotto.model.rank.RankResult;

public class LottoService {
    private final PurchaseRequestHandler purchaseRequestHandler;
    private final WinningNumbersRequestHandler winningNumbersRequestHandler;

    public LottoService(PurchaseRequestHandler purchaseRequestHandler,
                        WinningNumbersRequestHandler winningNumbersRequestHandler) {
        this.purchaseRequestHandler = purchaseRequestHandler;
        this.winningNumbersRequestHandler = winningNumbersRequestHandler;
    }

    public int getPurchaseCount(String amount) {
        return purchaseRequestHandler.getPurchaseAmount(amount);
    }

    public Lottos generateLottos(int count) {
        return Lottos.generate(count);
    }

    public List<Integer> getNumbers(List<String> numbersInput) {
        return winningNumbersRequestHandler.getNumbers(numbersInput);
    }

    public int getBonusNumber(String bonusInput, List<Integer> numbers) {
        return winningNumbersRequestHandler.getBonusNumber(bonusInput, numbers);
    }

    public LottoResultChecker createResultChecker(WinningNumbers winningNumbers) {
        return new LottoResultChecker(winningNumbers);
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
