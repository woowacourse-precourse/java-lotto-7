package lotto.view;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Prize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Output {

    public void printLottoNumbers(List<Lotto> lottos){
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (int i = 0; i < lottos.size(); i++) {
            System.out.print(lottos.get(i).getNumbers().toString());
            if (i != lottos.size() - 1) {
                System.out.println(",");
            }
        }
        System.out.println();
    }

    public void printPrizeStatistics(List<Prize> prizes, int amount) {
        List<Integer> prizeCount = new ArrayList<>(Collections.nCopies(Prize.values().length, 0));

        for (Prize prize : prizes) {
            if (prize != null) {
                prizeCount.set(prize.ordinal(), prizeCount.get(prize.ordinal()) + 1);
            }
        }

        int totalPrize = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = Prize.values().length - 1; i >= 0; i--) {
            Prize prize = Prize.values()[i];

            // 3개부터 6개까지 일치하는 경우만 출력
            if (prize.getMatchCount() >= 3) {
                int count = prizeCount.get(i); // 리스트에서 해당 개수를 가져옴
                System.out.printf("%d개 일치%s (%,d원) - %d개%n",
                        prize.getMatchCount(),
                        prize.getMatchBonus() ? ", 보너스 볼 일치" : "",
                        prize.getWinnings(),
                        count);
                totalPrize += count * prize.getWinnings();
            }
        }

        double profitRate = ((double) totalPrize / amount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

}
