package lotto.view;

import lotto.constant.LottoConstant;
import lotto.constant.LottoRank;
import lotto.constant.LottoResultsTracker;
import lotto.domain.LottoTickets;
import lotto.service.CalculatorService;
import lotto.service.WinningNumbersService;

public class OutputView {
    public static void LottoTicketsOutCome(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.LottoTicketsOutcome();
        System.out.println();
    }

    public static void LottoResultOutcome(LottoResultsTracker lottoResultsTracker) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoResultsTracker.getRankCount(LottoRank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResultsTracker.getRankCount(LottoRank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResultsTracker.getRankCount(LottoRank.THIRD) + "개");
        System.out.println(
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResultsTracker.getRankCount(LottoRank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResultsTracker.getRankCount(LottoRank.FIRST) + "개");
        allProfitOutcome(lottoResultsTracker);

    }

    private static void allProfitOutcome(LottoResultsTracker lottoResultsTracker) {
        CalculatorService calculatorService = new CalculatorService(new WinningNumbersService());
        double profit = calculatorService.getProfit(lottoResultsTracker);
        String result = calculatorService.profitCalculate(LottoConstant.purchase, profit);
        System.out.println("총 수익률은 " + result + "입니다.");

    }
}
