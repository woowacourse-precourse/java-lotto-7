package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.model.LottoRank;

public class ResultView {

    /**
     * 로또 티켓 발행 결과 출력
     *
     * @param tickets 발행된 로또 티켓 리스트
     */
    public void printLottoTickets(List<Lotto> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    /**
     * 당첨 결과 출력
     *
     * @param results 당첨 등수별 당첨 횟수 Map
     */
    public void printResults(
            Map<LottoRank, Integer> results,
            double yield
    ) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                System.out.printf("%s (%,d원) - %d개%n",
                        rank.getDescription(),
                        rank.getPrize(),
                        results.getOrDefault(rank, 0));
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}