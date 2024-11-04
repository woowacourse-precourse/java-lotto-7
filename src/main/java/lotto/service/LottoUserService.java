package lotto.service;

import lotto.model.administrator.Lotto;
import lotto.model.administrator.LottoBonusNumber;
import lotto.model.statistic.LottoStatisticsDto;
import lotto.model.statistic.Match;
import lotto.model.user.LotteryMachine;
import lotto.model.user.LottoResultDto;

public class LottoUserService {

    public LottoResultDto createLottoResult(final String insertedMoney) {
        return LottoResultDto.from(new LotteryMachine(insertedMoney));
    }

    public LottoStatisticsDto fetchStatistics(
            final LottoResultDto lottoResultDto,
            final Lotto winningNumbers,
            final LottoBonusNumber bonusNumber
    ) {
        Match match = new Match(
                winningNumbers.getNumbers(),
                bonusNumber.getBonusNumber(),
                lottoResultDto.lottoResults()
        );

        return LottoStatisticsDto.from(match, lottoResultDto);
    }
}
