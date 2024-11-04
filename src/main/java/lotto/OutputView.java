package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

    // 구매한 로또 번호를 출력하는 메서드
    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    // 당첨 결과를 출력하는 메서드
    public static void printResult(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Map.Entry<LottoRank, Integer> entry : result.getRankCounts().entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            System.out.println(rank.getDescription() + " - " + count + "개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", result.getYield());
    }
}