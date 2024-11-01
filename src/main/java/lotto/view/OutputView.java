package lotto.view;

import static lotto.constants.WinnerConstants.FIFTH_WINNER;
import static lotto.constants.WinnerConstants.FIRST_WINNER;
import static lotto.constants.WinnerConstants.FOURTH_WINNER;
import static lotto.constants.WinnerConstants.SECOND_WINNER;
import static lotto.constants.WinnerConstants.THIRD_WINNER;

import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;

public class OutputView {
    private static final String PURCHASE_COUNT = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---";
    private static final String PRIZE_DETAIL = "%d개 일치 (%,d원) - %d개\n";
    private static final String REVENUE_RESULT = "총 수익률은 %.1f%%입니다.";


    public void printPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + PURCHASE_COUNT);
    }

    public void printLottos(List<LottoDto> lottoDtos) {
        lottoDtos.forEach(lottoDto -> System.out.println(lottoDto.lotto()));
    }

    public void printWinningDetail(LottoResultDto dto) {
        System.out.println(WINNING_STATISTICS);
        System.out.printf(PRIZE_DETAIL, FIFTH_WINNER.getMatchCount(), FIFTH_WINNER.getPrizeMoney(),
                dto.result().getOrDefault(FIFTH_WINNER.getRank(), 0));
        System.out.printf(PRIZE_DETAIL, FOURTH_WINNER.getMatchCount(), FOURTH_WINNER.getPrizeMoney(),
                dto.result().getOrDefault(FOURTH_WINNER.getRank(), 0));
        System.out.printf(PRIZE_DETAIL, THIRD_WINNER.getMatchCount(), THIRD_WINNER.getPrizeMoney(),
                dto.result().getOrDefault(THIRD_WINNER.getRank(), 0));
        System.out.printf(PRIZE_DETAIL, SECOND_WINNER.getMatchCount(), SECOND_WINNER.getPrizeMoney(),
                dto.result().getOrDefault(SECOND_WINNER.getRank(), 0));
        System.out.printf(PRIZE_DETAIL, FIRST_WINNER.getMatchCount(), FIRST_WINNER.getPrizeMoney(),
                dto.result().getOrDefault(FIRST_WINNER.getRank(), 0));
    }

    public void printRevenueResult(LottoResultDto dto) {
        System.out.printf(REVENUE_RESULT, dto.rateOfReturn());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
