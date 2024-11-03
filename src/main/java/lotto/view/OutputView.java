package lotto.view;

import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static void purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void purchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            System.out.println(lotto.getNumbers());
        }
    }

    public static void userNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printResults(Map<Integer, Integer> rankResults) {
        System.out.println("당첨 통계");
        System.out.println("---");

        String[] rankDescriptions = {
                "3개 일치 (5,000원)",
                "4개 일치 (50,000원)",
                "5개 일치 (1,500,000원)",
                "5개 일치, 보너스 볼 일치 (30,000,000원)",
                "6개 일치 (2,000,000,000원)"
        };

        for (int i = 5; i >= 1; i--) {
            int count = rankResults.getOrDefault(i, 0);
            System.out.printf("%s - %d개%n", rankDescriptions[5 - i], count);
        }
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
