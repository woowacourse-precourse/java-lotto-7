package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final List<Lotto> lottos = new ArrayList<>();
    private Map<String, Integer> winnings = new HashMap<>();
    private static final Map<String, Integer> prizeAmounts = Map.of(
            "6개 일치", 2_000_000_000,
            "5개 일치, 보너스 볼 일치", 30_000_000,
            "5개 일치", 1_500_000,
            "4개 일치", 50_000,
            "3개 일치", 5_000
    );

    public void BuyLotto (int amount) {
        if (amount % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,0000원 단위여야 합니다.");
        }

        int quantity = amount / 1000;
        for (int i = 0; i < quantity; i++){
            List <Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        System.out.println(quantity+ "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void UpdateWinnings (List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();

            if (matchCount == 6) {
                winnings.put("6개 일치", winnings.getOrDefault("6개 일치", 0) + 1);
            }
            if (matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
                winnings.put("5개 일치, 보너스 볼 일치", winnings.getOrDefault("5개 일치, 보너스볼 일치", 0) + 1);
            }
            if (matchCount == 4) {
                winnings.put("4개 일치", winnings.getOrDefault("4개 일치", 0) + 1);
            }
            if (matchCount == 3) {
                winnings.put("3개 일치", winnings.getOrDefault("3개 일치", 0) + 1);
            }
        }
    }

    public void PrintWinnings(){
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", winnings.getOrDefault("3개 일치", 0));
        System.out.printf("4개 일치 (50,000원) - %d개%n", winnings.getOrDefault("4개 일치", 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", winnings.getOrDefault("5개 일치", 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", winnings.getOrDefault("5개 일치, 보너스 볼 일치", 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", winnings.getOrDefault("6개 일치", 0));
    }

    public void CalculateEarningsRate(int purchaseAmount) {
        int totalPrize = winnings.entrySet().stream()
                .mapToInt(entry -> prizeAmounts.getOrDefault(entry.getKey(),0) * entry.getValue())
                .sum();
        double earningsRate = ((double) totalPrize / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", Math.round(earningsRate * 10) / 10.0);
    }
}
