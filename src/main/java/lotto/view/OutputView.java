package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Ranking;
import lotto.dto.LottoOutputDto;

public class OutputView {

    private static final String LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String STATISTICS_MESSAGE = "당첨 통계\n---";
    private static final String WINNING_DETAIL_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String SECOND_WINNING_DETAIL_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RATE_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void showErrorMessage(String message) {
        System.out.println(message);
        System.out.println();
    }

    public void showLottos(Lottos lottos) {
        System.out.println();
        System.out.println(String.format(LOTTO_COUNT_FORMAT, lottos.getLottos().size()));
        lottos.getLottos().forEach(Lotto::printSortedNumbers);
        System.out.println();
    }

    public void showResult(LottoOutputDto lottoOutputDto) {
        System.out.println();
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
