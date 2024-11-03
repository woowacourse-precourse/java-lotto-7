package lotto.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
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
            int purchaseAmount = InputView.getPurchaseAmount();
            generateLottos(purchaseAmount);
            OutputView.printPurchaseAmountMessage(getPurchaseCount(purchaseAmount));
            OutputView.printUserLotto(userLottos);

            Set<Integer> winningNumbers = InputView.getWinningNumbers();
            int bonusNumber = InputView.getBonusNumber(winningNumbers);
            LottoResult winningResult = new LottoResult(winningNumbers, bonusNumber);

            Map<Rank, Integer> rankCount = rankCalculator.calculateRanks(userLottos, winningResult);
            long totalWinnings = winningCalculator.calculateTotalWinnings(rankCount);
            double roi = winningCalculator.calculateROI(totalWinnings, purchaseAmount);

            OutputView.printStatistics(rankCount, totalWinnings, roi);
        }catch (Exception e){
            System.out.println("[ERROR] 예기치 않은 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private void generateLottos(int purchaseAmount) {
        userLottos = lottoGenerator.generateLottos(getPurchaseCount(purchaseAmount));
    }

    private int getPurchaseCount(int purchaseAmount){
        return purchaseAmount / 1000;
    }
}
