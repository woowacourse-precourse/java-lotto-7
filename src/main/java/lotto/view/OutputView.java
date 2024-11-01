package lotto.view;

import lotto.domain.LottoResult;
import lotto.dto.LottoOutputDto;

public class OutputView {

    private static final String WINNING_DETAIL_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String RATE_MESSAGE_FORMAT = "총 수익률은 %f%%입니다";

    public void showResult(LottoOutputDto lottoOutputDto) {
        showWinningDetails(lottoOutputDto.lottoResult());
        showRateOfReturn(lottoOutputDto.rateOfReturn());
    }

    private void showWinningDetails(LottoResult lottoResult) {
        lottoResult.getLottoResult().forEach((ranking, numOfWinner) -> {
            System.out.println(String.format(WINNING_DETAIL_FORMAT, ranking.getMatchCount(), ranking.getWinningPrize(),
                    numOfWinner));
        });
    }

    private void showRateOfReturn(double rateOfReturn) {
        System.out.println(String.format(RATE_MESSAGE_FORMAT, rateOfReturn));
    }
}
