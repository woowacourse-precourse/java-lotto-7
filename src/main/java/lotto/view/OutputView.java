package lotto.view;

import java.util.List;

public class OutputView {

    private static final String OUTPUT_LOTTOS = "개를 구매했습니다.";
    private static final String OUTPUT_RESULT = "당첨 통계\n===";

    public static void printCount(int count) {
        System.out.println(count+OUTPUT_LOTTOS);
    }

    public static void printLottos(List<List<Integer>> lottos) {
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printResult(List<Integer> rankCount, double earningsRate) {
        System.out.println(OUTPUT_RESULT);

        for (int i = 0; i < rankCount.size(); i++) {
            if (i == 0) {
                String fifth = "3개 일치 (5,000원) - %d개".formatted(rankCount.get(rankCount.size()-i-1));
                System.out.println(fifth);
            }
            if (i == 1) {
                String fourth = "4개 일치 (50,000원) - %d개".formatted(rankCount.get(rankCount.size()-i-1));
                System.out.println(fourth);
            }
            if (i == 2) {
                String third = "5개 일치 (1,500,000원) - %d개".formatted(rankCount.size()-i-1);
                System.out.println(third);
            }
            if (i == 3) {
                String second = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개".formatted(rankCount.size()-i-1);
                System.out.println(second);
            }
            if (i == 4) {
                String first = "6개 일치 (2,000,000,000원) - %d개".formatted(rankCount.get(i));
                System.out.println(first);
            }
        }
        String result = "총 수익률은 %.1f%%입니다.".formatted(earningsRate);
        System.out.println(result);
    }
}
