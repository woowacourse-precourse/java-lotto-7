package lotto.view;

import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;

public class OutputView {
    private static final String PURCHASE_COUNT = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---";
    private static final String FIFTH_WINNER = "3개 일치 (5,000원) - %d개";
    private static final String FOURTH_WINNER = "4개 일치 (50,000원) - %d개";
    private static final String THIRD_WINNER = "5개 일치 (1,500,000원) - %d개";
    private static final String SECOND_WINNER = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String FIRST_WINNER = "6개 일치 (2,000,000,000원) - %d개";
    private static final String REVENUE_RESULT = "총 수익률은 %.1f%%입니다.";


    public void printPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + PURCHASE_COUNT);
    }

    public void printLottoNumberList(List<LottoDto> lottoDtos) {
        lottoDtos.forEach(System.out::println);
    }

    public void printWinningDetail(LottoResultDto dto) {
        System.out.println(WINNING_STATISTICS);
        System.out.printf(FIFTH_WINNER, dto.result().get(5));
        System.out.printf(FOURTH_WINNER, dto.result().get(4));
        System.out.printf(THIRD_WINNER, dto.result().get(3));
        System.out.printf(SECOND_WINNER, dto.result().get(2));
        System.out.printf(FIRST_WINNER, dto.result().get(1));
    }

    public void printRevenueResult(LottoResultDto dto) {
        System.out.printf(REVENUE_RESULT, dto.revenue());
    }


}
