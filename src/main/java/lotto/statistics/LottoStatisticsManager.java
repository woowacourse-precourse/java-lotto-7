package lotto.statistics;

import java.util.List;
import lotto.purchase.MyLotto;

public class LottoStatisticsManager {

    private final List<MyLotto> myLotteries;
    private final DrawInput drawInput = new DrawInput();
    private final WinningNumbersExtractor winningNumbersExtractor = new WinningNumbersExtractor();
    private final MatchCounter matchCounter = new MatchCounter();

    public LottoStatisticsManager(List<MyLotto> myLotteries) {
        this.myLotteries = myLotteries;
    }

    public DrawResultSheet process() {
        Lotto lotto = receiveWinningLotto();
        System.out.println();
        BonusBall bonusBall = receiveBonusBall(lotto.getNumbers());

        return new DrawResultSheet(totalMatchCount(lotto, bonusBall, myLotteries));
    }

    private Lotto receiveWinningLotto() {
        try {
            String rawWinningNumbers = drawInput.getWinningNumbers();

            return new Lotto(winningNumbersExtractor.extract(rawWinningNumbers));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return receiveWinningLotto();
        }
    }

    private BonusBall receiveBonusBall(List<Integer> winningNumbers) {
        try {
            String rawBonusNumber = drawInput.getBonusNumber();

            return new BonusBall(winningNumbersExtractor.extract(rawBonusNumber).get(0), winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return receiveBonusBall(winningNumbers);
        }
    }

    private List<Integer> totalMatchCount(Lotto winningLotto, BonusBall bonusBall, List<MyLotto> myLotteries) {
        for (MyLotto myLotto : myLotteries) {
            int matchedNumbers = winningLotto.countMatches(myLotto.numbers());
            boolean matchedBonusResult = bonusBall.matchBonus(myLotto.numbers());
            matchCounter.updateMatchResult(matchedNumbers, matchedBonusResult);
        }

        return matchCounter.getMatchedNumbers();
    }
}
