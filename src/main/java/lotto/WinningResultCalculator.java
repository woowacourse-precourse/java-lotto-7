package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResultCalculator {

    public Map<Rank, Integer> calculateResults(List<Lotto> userLottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> results = new HashMap<>();
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }

        for (Lotto userLotto : userLottos) {
            int matchCount = (int) userLotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean matchBonus = userLotto.getNumbers().contains(bonusNumber);

            Rank rank = Rank.valueOf(matchCount, matchBonus);
            results.put(rank, results.get(rank) + 1);
        }
        return results;
    }

    public void printResults(Map<Rank, Integer> results) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + results.get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + results.get(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + results.get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + results.get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + results.get(Rank.FIRST) + "개");
    }
}
