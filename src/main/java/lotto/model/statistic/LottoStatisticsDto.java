package lotto.model.statistic;

public record LottoStatisticsDto(
        int threeNumbersMatch,
        int fourNumbersMatch,
        int fiveNumbersMatch,
        int fiveAndBonusNumbersMatch,
        int sixNumbersMatch,
        int lotteryCount
) {

    public static LottoStatisticsDto of(
            int threeNumbersMatch,
            int fourNumbersMatch,
            int fiveNumbersMatch,
            int fiveAndBonusNumbersMatch,
            int sixNumbersMatch,
            int lotteryCount
    ) {
        return new LottoStatisticsDto(
                threeNumbersMatch,
                fourNumbersMatch,
                fiveNumbersMatch,
                fiveAndBonusNumbersMatch,
                sixNumbersMatch,
                lotteryCount
        );
    }
}
