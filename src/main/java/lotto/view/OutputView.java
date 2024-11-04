package lotto.view;

import lotto.domain.Lotto;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printPurchasedTickets(List<Lotto> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        tickets.forEach(ticket -> System.out.println(ticket.getNumbers()));
    }

    public static void printResults(Map<String, Integer> resultCounts, double roi) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + resultCounts.get("3개") + "개");
        System.out.println("4개 일치 (50,000원) - " + resultCounts.get("4개") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + resultCounts.get("5개") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultCounts.get("5개+보너스") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + resultCounts.get("6개") + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.%n", roi);
    }
}
