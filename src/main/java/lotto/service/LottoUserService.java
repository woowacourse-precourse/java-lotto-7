package lotto.service;

import static lotto.model.statistic.MatchList.FIVE_AND_BONUS_NUMBERS_MATCH;
import static lotto.model.statistic.MatchList.FIVE_NUMBERS_MATCH;
import static lotto.model.statistic.MatchList.FOUR_NUMBERS_MATCH;
import static lotto.model.statistic.MatchList.SIX_NUMBERS_MATCH;
import static lotto.model.statistic.MatchList.THREE_NUMBERS_MATCH;

import lotto.model.administrator.WinningLottoNumbersDto;
import lotto.model.statistic.LottoStatisticsDto;
import lotto.model.statistic.Match;
import lotto.model.user.LotteryMachine;
import lotto.model.user.LottoResultDto;

public class LottoUserService {

    public LottoResultDto createLottoResult(final String insertedMoney) {
        return LottoResultDto.from(new LotteryMachine(insertedMoney));
    }

    public LottoStatisticsDto fetchStatistics(LottoResultDto lottoResultDto, WinningLottoNumbersDto winningLottoNumbersDto) {
        Match match = new Match(
                winningLottoNumbersDto.lottoNumbers(),
                winningLottoNumbersDto.bonusNumber(),
                lottoResultDto.lottoResults());

        return LottoStatisticsDto.of(
                match.getMatchResult(THREE_NUMBERS_MATCH),
                match.getMatchResult(FOUR_NUMBERS_MATCH),
                match.getMatchResult(FIVE_NUMBERS_MATCH),
                match.getMatchResult(FIVE_AND_BONUS_NUMBERS_MATCH),
                match.getMatchResult(SIX_NUMBERS_MATCH),
                lottoResultDto.lotteryCount()
        );
    }
}
