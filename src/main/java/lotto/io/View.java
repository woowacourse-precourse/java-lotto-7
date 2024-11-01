package lotto.io;

import lotto.Lottos;

public class View {
    public void printLotto(Integer count, String lottos) {
        System.out.println(count + "개를 구매했습니다.");
        System.out.println(lottos);
    }

    public void printWinningResult(String results) {
        System.out.println("당첨통계");
        System.out.println("---");
        System.out.println(results);
    }

    public void printProfit(Integer profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
