package view;

import java.util.Set;

public class Output {
    private static final String PURCHASE_AMOUNT_FORMAT = "%d개를 구매했습니다.\n";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.2f입니다.\n";
    private static final String WINNING_RESULT_FORMAT = "당첨 통계\n---------\n";

    public void printPurchaseAmount(int purchaseAmount) {
        System.out.printf(PURCHASE_AMOUNT_FORMAT, purchaseAmount);
    }

    public void printLottoNumbers(Set<Set<Integer>>lottoNumbers) {
        lottoNumbers.forEach(System.out::println);
    }

    public void printWinningResult(int matchCount, boolean matchBonus) {
        System.out.println("WINNING_RESULT_FORMAT");
        //추후 lotto 관련 enum과 연계 구현할 것
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_FORMAT, profitRate);
    }

    public void printNewLine() {
        System.out.println();
    }

}
