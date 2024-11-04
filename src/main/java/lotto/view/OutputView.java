package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    // 구입한 로또 번호 출력
    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    // 당첨 통계 출력 - Map<Rank, Long>을 인자로 받도록 수정
    public static void printResults(Map<Rank, Long> results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", results.getOrDefault(Rank.FIFTH, 0L));
        System.out.printf("4개 일치 (50,000원) - %d개%n", results.getOrDefault(Rank.FOURTH, 0L));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", results.getOrDefault(Rank.THIRD, 0L));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", results.getOrDefault(Rank.SECOND, 0L));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", results.getOrDefault(Rank.FIRST, 0L));
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
