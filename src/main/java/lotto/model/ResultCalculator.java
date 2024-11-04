package lotto.model;

import java.util.HashMap;
import java.util.Map;
public class ResultCalculator {
    private final LottoList lottoList;
    private final WinningNumbers winningNumbers;
    private final Map<Rank, Integer> rankCounts; // 클래스 변수로 이동

    public ResultCalculator(LottoList lottoList, WinningNumbers winningNumbers) {
        this.lottoList = lottoList;
        this.winningNumbers = winningNumbers;
        this.rankCounts = new HashMap<>();
    }

    public void calculateResults() {
        for (Lotto lotto : lottoList.getLottoList()) {
            int count = countMatches(lotto);
            boolean bonus = lotto.getNumbers().contains(winningNumbers.getBonusNumber());

            Rank rank = Rank.getRank(count, bonus);
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
    }

    private int countMatches(Lotto lotto) {
        int count = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winningNumbers.getWinningNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }


}



