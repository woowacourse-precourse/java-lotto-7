package lotto.model.statistic;

import static lotto.model.statistic.MatchList.FIVE_AND_BONUS_NUMBERS_MATCH;
import static lotto.model.statistic.MatchList.FIVE_NUMBERS_MATCH;
import static lotto.model.statistic.MatchList.FOUR_NUMBERS_MATCH;
import static lotto.model.statistic.MatchList.SIX_NUMBERS_MATCH;
import static lotto.model.statistic.MatchList.THREE_NUMBERS_MATCH;

import lotto.model.user.LottoResultDto;

public record LottoStatisticsDto(
        int threeNumbersMatch,
        int fourNumbersMatch,
        int fiveNumbersMatch,
        int fiveAndBonusNumbersMatch,
        int sixNumbersMatch,
        int lotteryCount
) {
    public static LottoStatisticsDto from(Match match, LottoResultDto lottoResultDto) {
        return new LottoStatisticsDto(
                match.getMatchResult(THREE_NUMBERS_MATCH),
                match.getMatchResult(FOUR_NUMBERS_MATCH),
                match.getMatchResult(FIVE_NUMBERS_MATCH),
                match.getMatchResult(FIVE_AND_BONUS_NUMBERS_MATCH),
                match.getMatchResult(SIX_NUMBERS_MATCH),
                lottoResultDto.lotteryCount()
        );
    }
}
