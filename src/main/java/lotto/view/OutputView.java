package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.model.Lotto;
import lotto.domain.model.Rank;

public class OutputView {

    public static void promptPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchaseCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public static void promptWinningNumbersInput() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void promptBonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public static void printLottoResults(Map<Rank, Integer> statistics, double roi) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (%,d원) - %d개%n", Rank.FIFTH.getPrize(), statistics.get(Rank.FIFTH));
        System.out.printf("4개 일치 (%,d원) - %d개%n", Rank.FOURTH.getPrize(), statistics.get(Rank.FOURTH));
        System.out.printf("5개 일치 (%,d원) - %d개%n", Rank.THIRD.getPrize(), statistics.get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개%n", Rank.SECOND.getPrize(), statistics.get(Rank.SECOND));
        System.out.printf("6개 일치 (%,d원) - %d개%n", Rank.FIRST.getPrize(), statistics.get(Rank.FIRST));
        System.out.printf("총 수익률은 %.1f%%입니다.%n", roi);
    }
}