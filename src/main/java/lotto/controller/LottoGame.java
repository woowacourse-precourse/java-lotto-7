package lotto.controller;

import static lotto.view.InputView.getPurchaseAmount;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.service.LottoGenerator;
import lotto.service.RankCalculator;
import lotto.service.WinningsCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final LottoGenerator lottoGenerator;
    private final RankCalculator rankCalculator;
    private final WinningsCalculator winningCalculator;
    private List<Lotto> userLottos;

    public LottoGame() {
        this.lottoGenerator = new LottoGenerator();
        this.rankCalculator = new RankCalculator();
        this.winningCalculator = new WinningsCalculator();
    }

    public void start(){
        try{
            int purchaseAmount = getPurchaseAmount();
            generateAndDisplayLottos(purchaseAmount);
            LottoResult winningResult = getWinningResult();
            Map<Rank, Integer> rankCount = calculateRanks(winningResult);
            calculateAndDisplayROI(rankCount, purchaseAmount);
        }catch (Exception e){
            OutputView.printError(e);
        }
    }

    private void generateAndDisplayLottos(int purchaseAmount) {
        int purchaseCount = getPurchaseCount(purchaseAmount);
        userLottos = lottoGenerator.generateLottos(purchaseCount);
        OutputView.printPurchaseAmountMessage(purchaseCount);
        OutputView.printUserLotto(userLottos);
    }

    private Map<Rank, Integer> calculateRanks(LottoResult winningResult) {
        return rankCalculator.calculateRanks(userLottos, winningResult);
    }

    private void calculateAndDisplayROI(Map<Rank, Integer> rankCount, int purchaseAmount) {
        int totalWinnings = winningCalculator.calculateTotalWinnings(rankCount);
        double roi = winningCalculator.calculateROI(totalWinnings, purchaseAmount);
        OutputView.printStatistics(rankCount, roi);
    }

    private LottoResult getWinningResult() {
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber(winningNumbers);
        return new LottoResult(winningNumbers, bonusNumber);
    }

    private int getPurchaseCount(int purchaseAmount){
        return purchaseAmount / 1000;
    }
}
