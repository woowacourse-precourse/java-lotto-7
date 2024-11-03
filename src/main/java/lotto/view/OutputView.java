package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printPurchaseInfo(int ticketCount) {
        System.out.println("\n" + ticketCount + "개를 구매했습니다.");
    }

    public static void printLottoTickets(List<Lotto> tickets) {
        for (Lotto ticket : tickets) {
            System.out.println("[" + ticket.getFormattedNumbers() + "]");
        }
    }

    public static void printWinningResult(Map<Rank, Integer> result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.get(Rank.FIRST) + "개");
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}
