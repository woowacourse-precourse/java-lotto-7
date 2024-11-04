package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class OutputView {
    public static void printLottosNum(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            String numbers = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("[" + numbers + "]");
        }
    }

    public static void printResult(int[] results) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + results[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + results[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + results[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + results[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + results[4] + "개");
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
