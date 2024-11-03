package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.constant.Rank;

public class WinnerResult {
    private final Map<Rank, Integer> winningResult = new LinkedHashMap<>();
    private final int purchaseAmount;

    public WinnerResult(int purchaseAmount) {
        for (Rank rank : Rank.values()) {
            this.winningResult.put(rank, 0);
        }

        this.purchaseAmount = purchaseAmount;
    }

    public void add(Rank rank) {
        this.winningResult.put(rank, this.winningResult.getOrDefault(rank, 0) + 1);
    }

    public void display() {
        System.out.println("당첨 통계");
        System.out.println("---------");

        double total = 0;

        for (Map.Entry<Rank, Integer> entry : this.winningResult.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            total += rank.getPrizeMoney() * count;
            System.out.println(rank.getMessage() + " - " + count + "개");
        }

        System.out.println("총 수익률은 " + total / this.purchaseAmount * 100 + "%입니다.");
    }
}
