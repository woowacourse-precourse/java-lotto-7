package lotto;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;


// 구매한 로또 와 당첨번호를 비교하여 결과 출력, 수익률 출력
public class LottoResultDisplay {

    private static final LinkedHashMap<String, Integer> prizeMoney = new LinkedHashMap<>() {{
        put("3개 일치 ", 5000);
        put("4개 일치", 50000);
        put("5개 일치", 1500000);
        put("5개 일치, 보너스 볼 일치", 30000000);
        put("6개 일치", 2000000000);
    }};

    public static void displayResults(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber, int totalSpent) {
        LottoPrizeChecker checker = new LottoPrizeChecker(winningNumbers, bonusNumber);
        Map<String, Integer> results = new HashMap<>();

        int totalPrize = 0;
        for (Lotto lotto : purchasedLottos) {
            String result = checker.checkPrize(lotto.getNumbers());
            results.put(result, results.getOrDefault(result, 0) + 1);
            if (prizeMoney.containsKey(result)) {
                totalPrize += prizeMoney.get(result);
            }
        }

        displayStatistics(results);
        calculateReturns(totalSpent, totalPrize);
    }

    public static void displayStatistics(Map<String, Integer> results) {
        System.out.println("당첨 통계\n---");
        prizeMoney.forEach((rank, prize) -> {
            System.out.println(rank + " (" + String.format("%,d원)", prize) + " - " + results.getOrDefault(rank, 0) + "개");
        });
    }

    private static void calculateReturns(int totalSpent, int totalPrize) {
        double returns = ((double) totalPrize - totalSpent) / totalSpent * 100;
        System.out.printf("총 수익률은 %.2f%%입니다.\n", returns);
    }
}