package lotto.view;

import static lotto.util.LottoConstant.COST_UNIT;

import java.util.List;
import java.util.Set;
import lotto.model.statistic.LottoStatisticsDto;

public class OutputView {

    private static final String HOW_MANY_DID_YOU_PURCHASED = "%d개를 구매했습니다.\n";
    private static final String LOTTERY_RESULT = "당첨 통계\n";
    private static final String UP_AND_DOWN_DIVIDER = "---";
    private static final String THREE_NUMBERS_MATCH = "3개 일치 (5,000원) - ";
    private static final String FOUR_NUMBERS_MATCH = "4개 일치 (50,000원) - ";
    private static final String FIVE_NUMBERS_MATCH = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_AND_BONUS_NUMBERS_MATCH = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_NUMBERS_MATCH = "6개 일치 (2,000,000,000원) - ";
    private static final String COUNT_UNIT = "개";
    private static final String RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    private static final long THREE_MATCH_MONEY = 5_000;
    private static final long FOUR_MATCH_MONEY = 50_000;
    private static final long FIVE_MATCH_MONEY = 1_500_000;
    private static final long FIVE_AND_BONUS_MATCH_MONEY = 30_000_000;
    private static final long SIX_MATCH_MONEY = 2_000_000_000;
    private static final long PERCENTAGE = 100;

    public void printLottoResult(List<Set<Integer>> lottoResults, final int lotteryCount) {
        System.out.printf(HOW_MANY_DID_YOU_PURCHASED, lotteryCount);

        StringBuilder stringBuilder = new StringBuilder();
        for (Set<Integer> lottoResult : lottoResults) {
            stringBuilder.append(toPrettyString(lottoResult)).append("\n");
        }

        System.out.print(stringBuilder);
    }

    private String toPrettyString(Set<Integer> lottoResult) {
        return lottoResult.stream()
                .sorted()
                .map(String::valueOf)
                .toList()
                .toString();
    }

    public void printWinningResult(final LottoStatisticsDto lottoStatisticsDto) {
        System.out.println(LOTTERY_RESULT + UP_AND_DOWN_DIVIDER);
        System.out.println(winningResult(lottoStatisticsDto));
        System.out.printf(RATE_OF_RETURN, rateOfReturn(lottoStatisticsDto));
    }

    private double rateOfReturn(final LottoStatisticsDto lottoStatisticsDto) {
        double sum = lottoStatisticsDto.threeNumbersMatch() * THREE_MATCH_MONEY
                + lottoStatisticsDto.fourNumbersMatch() * FOUR_MATCH_MONEY
                + lottoStatisticsDto.fiveNumbersMatch() * FIVE_MATCH_MONEY
                + lottoStatisticsDto.fiveAndBonusNumbersMatch() * FIVE_AND_BONUS_MATCH_MONEY
                + lottoStatisticsDto.sixNumbersMatch() * SIX_MATCH_MONEY;

        double investmentAmount = lottoStatisticsDto.lotteryCount() * COST_UNIT.getNumber();
        return sum / investmentAmount * PERCENTAGE;
    }

    private String winningResult(final LottoStatisticsDto lottoStatisticsDto) {
        return THREE_NUMBERS_MATCH
                + lottoStatisticsDto.threeNumbersMatch()
                + COUNT_UNIT
                + "\n"

                + FOUR_NUMBERS_MATCH
                + lottoStatisticsDto.fourNumbersMatch()
                + COUNT_UNIT
                + "\n"

                + FIVE_NUMBERS_MATCH
                + lottoStatisticsDto.fiveNumbersMatch()
                + COUNT_UNIT
                + "\n"

                + FIVE_AND_BONUS_NUMBERS_MATCH
                + lottoStatisticsDto.fiveAndBonusNumbersMatch()
                + COUNT_UNIT
                + "\n"

                + SIX_NUMBERS_MATCH
                + lottoStatisticsDto.sixNumbersMatch()
                + COUNT_UNIT;
    }

    public void newLine() {
        System.out.println();
    }
}
