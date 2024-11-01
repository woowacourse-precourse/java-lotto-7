package lotto.service.impl;

import static lotto.utils.ErrorMessage.NOT_HAVE_BONUS_NUM;

import lotto.domain.LottoList;
import lotto.domain.LottoNum;
import lotto.domain.Money;
import lotto.domain.ProfitRate;
import lotto.domain.WinnerCountList;
import lotto.domain.WinnerLotto;
import lotto.domain.WinnerStatus;
import lotto.dto.LottoListDto;
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
    public LottoListDto generateLottoList(MoneyDto moneyDto) {
        Money money = moneyDto.money();

        return LottoList.generate(money)
                .toDto();
    }

    @Override
    public WinnerLotto addWinnerLotto(String input) {
        return WinnerLotto.create(input);
    }

    @Override
    public WinnerLotto addBonusNumber(WinnerLotto winnerLotto, String input) {
        LottoNum bonusNumber = LottoNum.create(input);

        return winnerLotto.addBonusNum(bonusNumber);
    }

    @Override
    public WinnerStatusDto calculateWinnerStatus(LottoListDto lottoListDto, WinnerLotto winnerLotto) {
        if (!winnerLotto.hasBonusNum()) {
            throw new IllegalStateException(NOT_HAVE_BONUS_NUM.getMessage());
        }

        LottoList lottoList = lottoListDto.lottoList();

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
