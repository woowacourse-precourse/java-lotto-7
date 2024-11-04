package lotto.service;

import lotto.exception.user.LottoMaximumExceededException;
import lotto.model.administrator.Lotto;
import lotto.model.administrator.LottoBonusNumber;
import lotto.model.statistic.LottoStatisticsDto;
import lotto.model.statistic.Match;
import lotto.model.user.LotteryMachine;
import lotto.model.user.LottoResultDto;
import lotto.util.ValidateUtil;

public class LottoUserService {

    public LottoResultDto createLottoResult(final String insertedMoney) {
        ValidateUtil.validateNumber(insertedMoney);
        int funds = ValidateUtil.parseToInt(insertedMoney, LottoMaximumExceededException::new);

        return LottoResultDto.from(new LotteryMachine(funds));
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
