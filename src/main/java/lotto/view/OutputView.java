package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.StringJoiner;

import lotto.policy.PrizeMoneyPolicy;

public class OutputView {
    private static final String PURCHASED_BUDGET = "구입금액을 입력해 주세요";
    private static final String NUMBER_OF_PURCHASES = "\n%s개를 구매했습니다.";
    private static final String WINNING_NUMBER = "\n당첨 번호를 입력해 주세요";
    private static final String BONUS_NUMBER = "\n보너스 번호를 입력해 주세요";
    private static final String WINNING_STATISTICS = "\n당첨 통계";
    private static final String MATCH_COUNT = "%s개 일치";
    private static final String MONEY = " (%s원)";
    private static final String COUNT = " - %s개";
    private static final String BONUS = ", 보너스 볼 일치";
    private static final String RATE_OF_RETURN = "총 수익률은 %s%%입니다.";

    public static void purchasedBudget() {
        System.out.println(PURCHASED_BUDGET);
    }

    public static void PurchasedLottoTicketsMessage(int lottoTickets) {
        System.out.println(String.format(NUMBER_OF_PURCHASES, lottoTickets));
    }

    public static void lottoNumbers(List<Integer> lotto) {
        System.out.println(lotto.toString());
    }

    public static void winningNumbers() {
        System.out.println(WINNING_NUMBER);
    }

    public static void bonusNumbers() {
        System.out.println(BONUS_NUMBER);
    }

    public static void winningStatistics() {
        System.out.println(WINNING_STATISTICS);
        System.out.println("---");
    }

    public static void result(PrizeMoneyPolicy rank, int count) {
        StringBuilder output = new StringBuilder();
        DecimalFormat formatter = new DecimalFormat("#,###");

        String formattedMoney = formatter.format(rank.getPriceMoney());
        output.append(String.format(MATCH_COUNT, rank.getMatchedCount()));

        if (rank.equals(PrizeMoneyPolicy.SECOND)) {
            output.append(String.format(BONUS));
        }
        output.append(String.format(MONEY, formattedMoney));
        output.append(String.format(COUNT, count));

        System.out.println(output.toString());
    }

    public static void totalRateOfReturn(double rateOfReturn) {
        String rate = String.format("%.1f", rateOfReturn);
        System.out.println(String.format(RATE_OF_RETURN, rate));
    }
}
