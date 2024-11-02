package lotto.view;

import lotto.model.LottoPrizeMoney;

public class ViewOutput {
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String COUNT_FIRST_MESSAGE = "6개 일치 (2,000,000,000원) - %d개%n";
    private static final String COUNT_SECOND_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n";
    private static final String COUNT_THIRD_MESSAGE = "5개 일치 (1,500,000원) - %d개%n";
    private static final String COUNT_FOURTH_MESSAGE = "4개 일치 (50,000원) - %d개%n";
    private static final String COUNT_FIFTH_MESSAGE = "3개 일치 (5,000원) - %d개%n";
    private static final String TOTAL_EARNING_RATE = "총 수익률은 %.1f%%입니다.%n";

    public void printResult(int countFirst, int countSecond, int countThird, int countFourth, int countFifth){
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println("---");
        System.out.printf(COUNT_FIFTH_MESSAGE, countFifth);
        System.out.printf(COUNT_FOURTH_MESSAGE, countFourth);
        System.out.printf(COUNT_THIRD_MESSAGE, countThird);
        System.out.printf(COUNT_SECOND_MESSAGE, countSecond);
        System.out.printf(COUNT_FIRST_MESSAGE, countFirst);
    }

    public void printEarningRateResult(float earningRate){
        String result = String.format(TOTAL_EARNING_RATE, earningRate);
        System.out.println(result);
    }

}
