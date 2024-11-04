package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Output {

    public void printLottoNumbers(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.stream()
                .map(lotto -> lotto.getNumbers().toString())
                .forEach(System.out::println);
    }

    public void printStatistics(List<Prize> prizes, int amount) {
        Map<Prize, Integer> prizeCount = countPrizes(prizes);
        int totalWinnings = calculateTotalPrize(prizeCount);

        System.out.println("당첨 통계");
        System.out.println("---");

        printPrize(prizeCount);

        double profitRate = ((double) totalWinnings / amount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private Map<Prize, Integer> countPrizes(List<Prize> prizes) {
        Map<Prize, Integer> prizeCount = new HashMap<>();

        for (Prize prize : prizes) {
            if (prize != Prize.NONE) {
                prizeCount.put(prize, prizeCount.getOrDefault(prize, 0) + 1);
            }
        }

        return prizeCount;
    }

    private int calculateTotalPrize(Map<Prize, Integer> prizeCount) {
        int totalWinning = 0;

        for (Map.Entry<Prize, Integer> entry : prizeCount.entrySet()) {
            Prize prize = entry.getKey();

            if (prize != Prize.NONE) {
                totalWinning += (entry.getValue() * prize.getWinnings());
            }
        }

        return totalWinning;
    }

    private void printPrize(Map<Prize, Integer> prizeCount) {
        for (Prize prize : Prize.values()) {
            if (prize != Prize.NONE) {
                int count = prizeCount.getOrDefault(prize, 0);
                System.out.printf("%s (%,d원) - %d개%n", prize.getMessage(), prize.getWinnings(), count);
            }
        }
    }
}
