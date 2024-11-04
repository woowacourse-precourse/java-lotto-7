package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Set;
import lotto.config.LottoConfig;
import lotto.model.domain.WinningMatch;

public class OutputView {
    public final static NumberFormat THOUSAND_SEPARATOR = NumberFormat.getInstance();
    public final static String BEFORE_PURCHASE = "구입금액을 입력해 주세요.";
    public final static String COUNT_PURCHASE = "%d개를 구매했습니다.";
    public final static String WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public final static String BOUNS_NUMBER = "보너스 번호를 입력해 주세요.";
    public final static String WINNING_STATISTIC = "당첨 통계";
    public final static String SEPERATOR = "---";
    public final static String STATISTIC_INFO = "%s (%s원) - %d개";
    public final static String TOTAL_RETURN_RATE = "총 수익률은 %s입니다.";

    public void purchaseLottoAmountMesssage() {
        System.out.println(BEFORE_PURCHASE);
    }

    public void purchaseLottoCountMessage(int ticketCount) {
        System.out.println();
        System.out.printf(COUNT_PURCHASE, ticketCount);
    }

    public void printLottoNumbers(List<String> lottoNumbers) {
        System.out.println();
        for (String lotterNumber : lottoNumbers) {
            System.out.println(lotterNumber);
        }
        System.out.println();
    }

    public void enterWinningNumbers() {
        System.out.println(WINNING_NUMBERS);
    }

    public void enterBonusNumber() {
        System.out.println();
        System.out.println(BOUNS_NUMBER);

    }

    public void WinningStatistics() {
        System.out.println();
        System.out.println(WINNING_STATISTIC);
        System.out.println(SEPERATOR);
    }

    public void matchWinningCount(List<Integer> winningCounts) {
        for (int rank = winningCounts.size(); rank > LottoConfig.ZERO; rank--) {
            int winningCount = winningCounts.get(rank - 1);
            System.out.printf(STATISTIC_INFO,
                    WinningMatch.valueOfRank(rank).getMatchAmount(),
                    THOUSAND_SEPARATOR.format(WinningMatch.valueOfRank(rank).getPriceAmount()),
                    winningCount
            );
            System.out.println();
        }
    }

    public void promptTotalReturnRate(String totalReturnRate) {
        System.out.printf(TOTAL_RETURN_RATE, totalReturnRate);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
