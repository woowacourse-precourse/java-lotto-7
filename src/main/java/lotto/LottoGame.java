package lotto;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private final LottoStore lottoStore;
    private final LottoGameDisplay lottoGameDisplay;

    public LottoGame() {
        this.lottoStore = new LottoStore();
        this.lottoGameDisplay = new LottoGameDisplay();
    }

    public void run() {
        int money = lottoGameDisplay.inputMoney();
        List<Lotto> lottos = lottoStore.purchase(money);
        lottoGameDisplay.printPurchaseBreakdown(lottos);

        List<Integer> winnerNumbers = lottoGameDisplay.inputWinnerNumbers();
        int bonusNumber = lottoGameDisplay.inputBonusNumber(winnerNumbers);

        List<LottoRank> lottoRanks = checkLottosRank(lottos, winnerNumbers, bonusNumber);

        double rateOfResult = LottoStatistics.calcRateOfReturn(money, lottoRanks);
        Map<LottoRank, Integer> rankMap = LottoStatistics.calcRankStatistics(lottoRanks);
        lottoGameDisplay.printWinStatistics(rankMap, rateOfResult);
    }

    private List<LottoRank> checkLottosRank(List<Lotto> lottos, List<Integer> winnerNumbers, int bonus) {
        List<LottoRank> lottoRanks = new ArrayList<>();

        for (Lotto lotto : lottos) {
            LottoRank lottoRank = lotto.checkRank(winnerNumbers, bonus);
            lottoRanks.add(lottoRank);
        }

        return lottoRanks;
    }
}
