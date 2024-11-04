package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printPurchasedTickets(List<Lotto> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public static void printResults(Map<LottoResult, Integer> results, int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        int totalPrize = 0;
        for (LottoResult result : LottoResult.values()) {
            int count = results.getOrDefault(result, 0);
            totalPrize += result.getPrize() * count;
            if (result != LottoResult.NONE) {
                System.out.printf("%d개 일치 (%d원) - %d개%n", result.ordinal() + 3, result.getPrize(), count);
            }
        }
        double returnRate = (double) totalPrize / purchaseAmount * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", returnRate);
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
