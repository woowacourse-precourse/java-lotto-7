package lotto.view;

import static lotto.util.LottoConstant.COST_UNIT;
import static lotto.view.ViewConstant.DIVIDER;
import static lotto.view.ViewConstant.HOW_MANY_DID_YOU_PURCHASED;
import static lotto.view.ViewConstant.LOTTERY_RESULT;

import java.util.List;
import java.util.Set;
import lotto.model.statistic.LottoStatisticsDto;

public class OutputView {

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

    public void printLottoResult(List<Set<Integer>> lottoResults, int lotteryCount) {
        System.out.printf(HOW_MANY_DID_YOU_PURCHASED.getMessage(), lotteryCount);

        StringBuilder stringBuilder = new StringBuilder();
        for(Set<Integer> lottoResult : lottoResults) {
            stringBuilder.append(toPrettyString(lottoResult));
        }

        System.out.println(stringBuilder);
    }

    private String toPrettyString(Set<Integer> lottoResult) {
        List<String> numbersToString =
                lottoResult.stream()
                .sorted()
                .map(Object::toString)
                .toList();

        return "[" + String.join(", ", numbersToString) + "]" + "\n";
    }

    public void printWinningResult(LottoStatisticsDto lottoStatisticsDto) {
        System.out.println(LOTTERY_RESULT.getMessage() + DIVIDER.getMessage());
        System.out.println(winningResult(lottoStatisticsDto));
        System.out.printf(RATE_OF_RETURN, rateOfReturn(lottoStatisticsDto));
    }

    private double rateOfReturn(LottoStatisticsDto lottoStatisticsDto) {
        double sum = 0;
        sum += lottoStatisticsDto.threeNumbersMatch() * THREE_MATCH_MONEY;
        sum += lottoStatisticsDto.fourNumbersMatch() * FOUR_MATCH_MONEY;
        sum += lottoStatisticsDto.fiveNumbersMatch() * FIVE_MATCH_MONEY;
        sum += lottoStatisticsDto.fiveAndBonusNumbersMatch() * FIVE_AND_BONUS_MATCH_MONEY;
        sum += lottoStatisticsDto.sixNumbersMatch() * SIX_MATCH_MONEY;

        double investmentAmount = lottoStatisticsDto.lotteryCount() * COST_UNIT.getNumber();
        return sum / investmentAmount * PERCENTAGE;
    }

    private String winningResult(LottoStatisticsDto lottoStatisticsDto) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(THREE_NUMBERS_MATCH)
                .append(lottoStatisticsDto.threeNumbersMatch())
                .append(COUNT_UNIT)
                .append("\n")

                .append(FOUR_NUMBERS_MATCH)
                .append(lottoStatisticsDto.fourNumbersMatch())
                .append(COUNT_UNIT)
                .append("\n")

                .append(FIVE_NUMBERS_MATCH)
                .append(lottoStatisticsDto.fiveNumbersMatch())
                .append(COUNT_UNIT)
                .append("\n")

                .append(FIVE_AND_BONUS_NUMBERS_MATCH)
                .append(lottoStatisticsDto.fiveAndBonusNumbersMatch())
                .append(COUNT_UNIT)
                .append("\n")

                .append(SIX_NUMBERS_MATCH)
                .append(lottoStatisticsDto.sixNumbersMatch())
                .append(COUNT_UNIT);

        return stringBuilder.toString();
    }

    public void newLine() {
        System.out.println();
    }
}
