package lotto.view;

public class StatisticsView {
    private static final String WINNING_STATSTICS =
            """
                        당첨 통계
                        ---
                    """;
    private static final String THREE_MATCHED = "3개 일치 (5,000원) - ";
    private static final String FOUR_MATCHED = "4개 일치 (50,000원) - ";
    private static final String FIVE_MATCHED = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_BONUS_MATCHED = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_MATCHED = "6개 일치 (2,000,000,000원) - ";
    private static final String MATCHED_END_UNIT = "개\n";
    private static final String REVENUE_START_UNIT = "총 수익률은 ";
    private static final String REVENUE_END_UNIT = "%입니다.";

    public void getStatistics(int three, int four, int five, int fiveBonus, int six) {
        System.out.println(
                WINNING_STATSTICS
                        + THREE_MATCHED + three + MATCHED_END_UNIT
                        + FOUR_MATCHED + four + MATCHED_END_UNIT
                        + FIVE_MATCHED + five + MATCHED_END_UNIT
                        + FIVE_BONUS_MATCHED + fiveBonus + MATCHED_END_UNIT
                        + SIX_MATCHED + six + MATCHED_END_UNIT);
    }

    public void getRevenueRate(double rate) {
        System.out.println(REVENUE_START_UNIT + rate + REVENUE_END_UNIT);
    }
}
