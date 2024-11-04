package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningRank;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class OutputView {
    // 구매한 로또 출력 메소드
    public void purchaseTickets(List<Lotto> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
        System.out.println();
    }

    // 당첨 결과 출력 메소드
    public void printResult(LottoResult result, int amount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (WinningRank rank : WinningRank.values()) {
            int count = result.getResults().getOrDefault(rank, 0);
            String matchMessage = formatMatchMessage(rank);
            System.out.println(matchMessage + " (" + formatPrize(rank.getPrize()) + "원) - " + count + "개");
        }
        long totalPrize = result.totalPrize();
        double rate = (double) totalPrize / amount;
        System.out.println("총 수익률은 " + Math.round(rate * 100 * 100) / 100.0 + "%입니다.");
    }

    private String formatMatchMessage(WinningRank rank) {
        if (rank == WinningRank.SECOND) {
            return "5개 일치, 보너스 볼 일치";
        }
        return rank.getMatchCount() + "개 일치";
    }

    private String formatPrize(int prize) {
        return NumberFormat.getNumberInstance(Locale.KOREA).format(prize);
    }
}
