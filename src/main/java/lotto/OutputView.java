package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

    private final static String PRINT_QUANTITY = "개를 구매했습니다.";
    private final static String PRINT_RESULT_STATISTICS = "당첨 통계\n";
    private final static String PRINT_LINE = "---\n";

    public static void printReceipt(LottoReceipt lottoReceipt) {
        System.out.println(lottoReceipt.getQuantity() + PRINT_QUANTITY);
        for (Lotto lottery : lottoReceipt.getLotteries()) {
            System.out.println(lottery);
        }

    }

    public static void printResult(WinningNumber winningNumber, List<Lotto> lotteries, int totalAmount) {
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningNumber);
        Map<Rank, Integer> rankingResult = lottoResultCalculator.calculateRanking(lotteries);
        double rateOfReturn = lottoResultCalculator.calculateRateOfReturn(rankingResult, totalAmount);

        StringBuilder output = new StringBuilder();
        output.append(PRINT_RESULT_STATISTICS);
        output.append(PRINT_LINE);

        output.append(String.format("3개 일치 (5,000원) - %d개\n", rankingResult.getOrDefault(Rank.FIFTH_PLACE, 0)));
        output.append(String.format("4개 일치 (50,000원) - %d개\n", rankingResult.getOrDefault(Rank.FORTH_PLACE, 0)));
        output.append(String.format("5개 일치 (1,500,000원) - %d개\n", rankingResult.getOrDefault(Rank.THIRD_PLACE, 0)));
        output.append(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", rankingResult.getOrDefault(Rank.SECOND_PLACE, 0)));
        output.append(String.format("6개 일치 (2,000,000,000원) - %d개\n", rankingResult.getOrDefault(Rank.FIRST_PLACE, 0)));

        System.out.println(output);
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
