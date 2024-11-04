package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    public void calculateAndDisplay(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber, int purchaseAmount) {
        Map<Integer, Integer> statistics = new HashMap<>();

        for (int i = 3; i <= 6; i++) {
            statistics.put(i, 0);
        }
        statistics.put(5, 0); // 5개 + 보너스

        for (Lotto lotto : lottos) {
            long matchCount = lotto.getNumbers().stream().filter(winningNumbers::contains).count();
            if (matchCount >= 3) {
                if (matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
                    statistics.put(5, statistics.get(5) + 1);
                } else {
                    statistics.put((int) matchCount, statistics.get((int) matchCount) + 1);
                }
            }
        }

        // 결과 출력
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", statistics.get(3));
        System.out.printf("4개 일치 (50,000원) - %d개%n", statistics.get(4));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", statistics.get(5));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", statistics.get(5));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", statistics.get(6));

        // 수익률 계산
        double totalWinnings = statistics.get(3) * 5000 +
                statistics.get(4) * 50000 +
                statistics.get(5) * 1500000 +
                statistics.get(5) * 30000000 +
                statistics.get(6) * 2000000000;

        double roi = (totalWinnings / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", roi);
    }
}
