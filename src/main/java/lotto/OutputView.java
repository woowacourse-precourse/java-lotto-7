package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutputView {

    public void printLottoNumbers(List<List<Integer>> lottos) {
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for (List<Integer> lotto:lottos) {
            System.out.println(lotto);
        }
    }

    public void printReturnOfRate(String rateOfReturn) {
        System.out.printf("총 수익률은 %s%%입니다.", rateOfReturn);
        System.out.println();
    }

    public void printPrizeResults() {
        for (int i = WinningPrize.values().length - 1; i >= 0; i--) {
            WinningPrize prize = WinningPrize.values()[i];
            String pp = String.format("%,d",prize.prizeMoney);
            String tt =String.format("%d개 일치 (%s원) - %d개",prize.winningCount,pp,prize.totalCount);
            String yy =String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개",prize.winningCount,pp,prize.totalCount);
            if (prize.bonusCount == 0) {
                System.out.println(tt);
            }
            if (prize.bonusCount == 1) {
                System.out.println(yy);
            }
        }
    }
}
