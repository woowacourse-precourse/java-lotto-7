package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;


public class OutputView {

    public void printLottoQuantity(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println("[" + lotto.getIndex(0) + ", " + lotto.getIndex(1) + ", " + lotto.getIndex(2) + ", "
                    + lotto.getIndex(3) + ", " + lotto.getIndex(4) + ", " + lotto.getIndex(5) + "]");
        }
    }

    public void printLottoWinningDetails(Map<Rank, Integer> map) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + map.get(Rank.FIVE) + "개");
        System.out.println("4개 일치 (50,000원) - " + map.get(Rank.FOUR) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + map.get(Rank.THREE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + map.get(Rank.TWO) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + map.get(Rank.ONE) + "개");
    }

    public void printLottoYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.", yield);
    }
}
