package lotto;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.display.LottoGameInputDisplay;
import lotto.display.LottoGameOutputDisplay;

public class LottoGame {

    private final LottoStore lottoStore;
    private final LottoGameInputDisplay inputDisplay;
    private final LottoGameOutputDisplay outputDisplay;

    public LottoGame() {
        this.lottoStore = new LottoStore();
        this.outputDisplay = new LottoGameOutputDisplay();
        this.inputDisplay = new LottoGameInputDisplay(outputDisplay);
    }

    public void run() {
        // 로또 구매
        int money = inputDisplay.inputMoney();
        List<Lotto> lottos = lottoStore.purchase(money);
        outputDisplay.printPurchaseBreakdown(lottos);

        // 당첨 번호 설정
        List<Integer> winnerNumbers = inputDisplay.inputWinnerNumbers();
        int bonusNumber = inputDisplay.inputBonusNumber(winnerNumbers);
        // 당첨 확인
        List<LottoRank> lottoRanks = checkLottosRank(lottos, winnerNumbers, bonusNumber);

        // 당첨 통계 계산
        double rateOfResult = LottoStatistics.calcRateOfReturn(money, lottoRanks);
        Map<LottoRank, Integer> winningCntPerRank = LottoStatistics.calcRankStatistics(lottoRanks);
        outputDisplay.printWinStatistics(winningCntPerRank, rateOfResult);
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
