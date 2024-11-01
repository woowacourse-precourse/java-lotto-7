package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Ranking;
import lotto.dto.LottoOutputDto;

public class OutputView {

    private static final String LOTTO_COUNT_FORMAT = "\n%d개를 구매했습니다";
    private static final String STATISTICS_MESSAGE = "\n당첨 통계\n---";
    private static final String WINNING_DETAIL_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String SECOND_WINNING_DETAIL_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RATE_MESSAGE_FORMAT = "\n총 수익률은 %.1f%%입니다";

    public void showLottos(Lottos lottos) {
        System.out.println(String.format(LOTTO_COUNT_FORMAT, lottos.getLottos().size()));
        lottos.getLottos().forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
    }

    public void showStatistics(LottoOutputDto lottoOutputDto) {
        System.out.println(STATISTICS_MESSAGE);
        showWinningDetails(lottoOutputDto.lottoResult());
        showRateOfReturn(lottoOutputDto.rateOfReturn());
    }

    private void showWinningDetails(LottoResult lottoResult) {
        lottoResult.getLottoResult().forEach((ranking, numOfWinner) -> {
            if (ranking != Ranking.SECOND) {
                System.out.println(
                        String.format(WINNING_DETAIL_FORMAT, ranking.getMatchCount(),
                                String.format("%,d", ranking.getWinningPrize()),
                                numOfWinner));
            } else {
                System.out.println(
                        String.format(SECOND_WINNING_DETAIL_FORMAT, ranking.getMatchCount(),
                                String.format("%,d", ranking.getWinningPrize()),
                                numOfWinner));
            }
        });
    }

    private void showRateOfReturn(double rateOfReturn) {
        System.out.println(String.format(RATE_MESSAGE_FORMAT, rateOfReturn));
    }
}
