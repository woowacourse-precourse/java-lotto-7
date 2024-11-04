package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoStatisticsDto;
import lotto.model.LottoTickets;

public class LottoGameOutputView {

    private LottoGameOutputView() {
    }

    public static void printTicketCount(LottoTickets lottoTickets) {
        System.out.println();
        System.out.println(lottoTickets.getTicketCount() + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
        System.out.println();
    }

    public static void printLottoStatistics(LottoStatisticsDto lottoStatisticsDto) {
        System.out.println("당첨 통계");
        System.out.println("---");

        // sortedRankCounts를 출력
        for (Map.Entry<LottoRank, Integer> entry : lottoStatisticsDto.getSortedRankCounts()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();

            if (rank.isBonus()) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n", rank.getMatchCount(), formatPrize(rank.getPrize()),
                        count);
            } else {
                System.out.printf("%d개 일치 (%s원) - %d개%n", rank.getMatchCount(), formatPrize(rank.getPrize()), count);
            }
        }

        // 수익률 출력
        System.out.printf("총 수익률은 %.1f%%입니다.%n", lottoStatisticsDto.getProfitRate());
    }

    // 금액을 3자리마다 콤마로 포맷하는 메서드
    private static String formatPrize(int prize) {
        return String.format("%,d", prize);
    }
}
