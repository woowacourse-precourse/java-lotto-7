package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.Prize;

public class OutputView {
    private static final String MY_LOTTOS_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String STATISTICS_HEADER = "\n당첨 통계\n---";
    private static final String MATCH_MESSAGE = "%d개 일치 (%,d원) - %d개";
    private static final String BONUS_MATCH_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void showMyLottos(Lottos lottos, int purchaseCount) {
        System.out.println(String.format(MY_LOTTOS_MESSAGE, purchaseCount));
        lottos.getLottos().stream()
                .map(Lotto::getNumbers)
                .forEach(numbers -> System.out.println(numbers));
    }

    public void printStatistics(LottoResult lottoResult) {
        System.out.println(STATISTICS_HEADER);

        // Rank Enum을 사용하여 각 당첨 등수를 출력합니다.
        printRankStatistics(lottoResult, Prize.FIFTH);
        printRankStatistics(lottoResult, Prize.FOURTH);
        printRankStatistics(lottoResult, Prize.THIRD);
        printRankStatisticsWithBonus(lottoResult, Prize.SECOND);
        printRankStatistics(lottoResult, Prize.FIRST);
    }

    private void printRankStatistics(LottoResult lottoResult, Prize prize) {
        int count = lottoResult.getRankCount(prize);
        System.out.println(String.format(MATCH_MESSAGE, prize.getCorrectCount(), prize.getResultPrize(), count));
    }

    private void printRankStatisticsWithBonus(LottoResult lottoResult, Prize prize) {
        int count = lottoResult.getRankCount(prize);
        System.out.println(String.format(BONUS_MATCH_MESSAGE, prize.getCorrectCount(), prize.getResultPrize(), count));
    }

    public void printProfitRate(double profitRate) {
        System.out.println(String.format(PROFIT_RATE_MESSAGE, profitRate));
    }

}
