package lotto.view;

import static lotto.constants.LottoConstants.WINNERS;

import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;

public class OutputView {
    private static final String PURCHASE_COUNT = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---";
    private static final String PRIZE_DETAIL = "%s (%,d원) - %d개\n";
    private static final String REVENUE_RESULT = "총 수익률은 %,.1f%%입니다.";


    public void printPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + PURCHASE_COUNT);
    }

    public void printLottos(List<LottoDto> lottoDtos) {
        lottoDtos.forEach(lottoDto -> System.out.println(lottoDto.lotto()));
    }

    public void printWinningDetail(LottoResultDto dto) {
        System.out.println(WINNING_STATISTICS);

        WINNERS.forEach(winner -> {
            System.out.printf(
                    PRIZE_DETAIL,
                    winner.getMessage(),
                    winner.getPrizeMoney(),
                    dto.prizeMatchResults().getOrDefault(winner.getRank(), 0)
            );
        });
    }

    public void printRevenueResult(LottoResultDto dto) {
        System.out.printf(REVENUE_RESULT, dto.rateOfReturn());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
