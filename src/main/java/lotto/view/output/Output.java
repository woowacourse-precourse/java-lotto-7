package lotto.view.output;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.view.Winnings;

public class Output {

    public HashMap<Integer, List<Integer>> getLottoNumbers(int getPurchaseAccount) {
        System.out.println(getPurchaseAccount + "개를 구매했습니다.");

        HashMap<Integer, List<Integer>> getLottoNumbers = new HashMap<>();

        for(int i = 0 ; i< getPurchaseAccount; i++){
            getLottoNumbers.put(i, Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().toList());
            System.out.println(getLottoNumbers.get(i));
        }

        return getLottoNumbers;
    }

    public void printStatistics(Map<Winnings, Integer> winningsStats) {
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Winnings winnings : Winnings.values()) {
            int count = winningsStats.getOrDefault(winnings, 0);
            System.out.println(winnings.getDescription() + " - " + count + "개");
        }
    }

    public void printCalculateWinningsRate(double calculateWinningsRate) {
        System.out.println("총 수익률은 " + calculateWinningsRate + "%입니다.");
    }
}
