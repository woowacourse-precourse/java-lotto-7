package lotto.view;

import lotto.model.Lotto;
import lotto.util.Rank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class UserView {

    public void displayInputMessageOfLottoAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void displayInputMessageOfWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void displayInputMessageOfBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void displayCountOfLottos(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void displayLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void displayStatisticsMessage() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    public void displayStatistics(Map<Rank, Integer> results) {
        DecimalFormat df = new DecimalFormat("###,###");

        for(Rank rank : Rank.values()) {
            int count = results.getOrDefault(rank, 0);

            if (rank == Rank.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n", rank.getBalls(), df.format(rank.getWinningPrize()), count);
                continue;
            }
            System.out.printf("%d개 일치 (%s원) - %d개%n", rank.getBalls(), df.format(rank.getWinningPrize()), count);
        }
    }

    public void displayProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profit);
    }

}
