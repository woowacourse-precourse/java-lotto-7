package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoRankCount;
import lotto.model.LottoStatisticsDto;

public class LottoGameOutputView {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    private LottoGameOutputView() {
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printLottoStatistics(LottoStatisticsDto lottoStatisticsDto) {
        System.out.println("당첨 통계");
        System.out.println("---");

        // sortedRankCounts 출력
        lottoStatisticsDto.getSortedRankCounts().forEach(LottoGameOutputView::printRankCount);

        // 수익률 출력
        System.out.printf("총 수익률은 %.1f%%입니다.%n", lottoStatisticsDto.getProfitRate());
    }

    // 각 랭크와 개수를 출력하는 메서드 추출
    private static void printRankCount(LottoRankCount rankCount) {
        LottoRank rank = rankCount.rank();
        int count = rankCount.count();

        if (rank.isBonus()) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n",
                    rank.getMatchCount(), formatPrize(rank.getPrize()), count);
        } else {
            System.out.printf("%d개 일치 (%s원) - %d개%n",
                    rank.getMatchCount(), formatPrize(rank.getPrize()), count);
        }
    }

    // 금액을 3자리마다 콤마로 포맷하는 메서드
    private static String formatPrize(int prize) {
        return String.format("%,d", prize);
    }


    public static void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_PREFIX + message);
    }
}
