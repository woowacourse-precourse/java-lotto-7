package lotto.view;

import lotto.domain.UserLotto;
import lotto.domain.WinningRank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void userResult(int count, List<UserLotto> userLotto) {
        System.out.println(count + "개를 구매했습니다.");

        userLotto.forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
    }

    public void statistics(Map<WinningRank, Long> rankCounts) {
        System.out.println("당첨 통계");
        System.out.println("---");

        rankCounts.forEach((rank, count) -> {
            System.out.println(rank.getResultMessage() + " - " + count + "개");
        });
    }

    public void profitRate(Long prize, int cost) {
        double rate = ((double) prize / cost) * 100;
        double roundedRate = Math.round(rate * 100) / 100.0; // 수익률을 소수점 두 자리로 반올림

        System.out.println("총 수익률은 " + roundedRate + "%입니다.");
    }
}
