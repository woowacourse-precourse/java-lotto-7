package lotto.view;

import java.util.Collections;
import java.util.List;

public class OutputView {
    public void printGeneratedNum(List<List<Integer>> lottos){
        System.out.printf("\n%d개를 구매했습니다.",lottos.size());
        for(List<Integer> lotto : lottos){
            Collections.sort(lotto);
            System.out.println(lotto);
        }
    }

    public void printWinning(int[] resultWinning){
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", resultWinning[3]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", resultWinning[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", resultWinning[5]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", resultWinning[6]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", resultWinning[7]);
    }

    public void printTotalProfit(float totalProfit){
        System.out.printf("총 수익률은 %.2f%%입니다.\n", totalProfit);
    }
}
