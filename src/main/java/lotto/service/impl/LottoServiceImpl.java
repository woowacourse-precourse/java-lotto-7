package lotto.service.impl;

import lotto.domain.LottoList;
import lotto.domain.LottoNum;
import lotto.domain.Money;
import lotto.domain.ProfitRate;
import lotto.domain.WinnerCountList;
import lotto.domain.WinnerLotto;
import lotto.domain.WinnerStatus;
import lotto.dto.MoneyDto;
import lotto.dto.ProfitRateResultDto;
import lotto.dto.WinnerStatusDto;
import lotto.service.LottoService;

public class LottoServiceImpl implements LottoService {
    @Override
    public MoneyDto covertToMoney(String input) {
        return Money.create(input)
                .toDto();
    }

    @Override
    public LottoList generateLottoList(MoneyDto moneyDto) {
        Money money = moneyDto.money();

        return LottoList.generate(money);
    }

    @Override
    public WinnerLotto createWinnerLotto(String input) {
        return WinnerLotto.create(input);
    }

    @Override
    public WinnerLotto addBonusNumber(WinnerLotto winnerLotto, String input) {
        LottoNum bonusNumber = LottoNum.create(input);

        return winnerLotto.addBonusNum(bonusNumber);
    }

    @Override
    public WinnerStatusDto calculateWinnerStatus(LottoList lottoList, WinnerLotto winnerLotto) {
        if (winnerLotto.hasBonusNum()) {
            throw new IllegalStateException("보너스 번호가 들어가지 않았습니다.");
        }

        WinnerCountList winnerCountList = WinnerCountList.of(lottoList, winnerLotto);
        WinnerStatus winnerStatus = WinnerStatus.create(winnerCountList);

        return winnerStatus.toDto();
    }

    @Override
    public ProfitRateResultDto calculateProfitRate(WinnerStatusDto winnerStatusDto, MoneyDto moneyDto) {
        Money money = moneyDto.money();
        WinnerStatus winnerStatus = winnerStatusDto.winnerStatus();

        ProfitRate profitRate = ProfitRate.create(money, winnerStatus);
        return profitRate.toDto();
    }
}
