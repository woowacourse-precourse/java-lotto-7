package lotto.service.impl;

import lotto.domain.LottoList;
import lotto.domain.Money;
import lotto.domain.ProfitRate;
import lotto.domain.WinnerNumber;
import lotto.domain.WinnerStatus;
import lotto.service.LottoService;

public class LottoServiceImpl implements LottoService {
    @Override
    public Money covertToMoney(String input) {
        return Money.create(input);
    }

    @Override
    public LottoList generateLottoList(Money money) {
        return LottoList.generate(money);
    }

    @Override
    public WinnerNumber createWinnerNumber(String winnerNumber) {
        return null;
    }

    @Override
    public WinnerNumber addBonusNumber(String bonusNumber) {
        return null;
    }

    @Override
    public WinnerStatus calculateWinnerStatus(LottoList lottoList, WinnerNumber winnerNumber) {
        return null;
    }

    @Override
    public ProfitRate calculateProfitRate(WinnerStatus winnerStatus, Money money) {
        return null;
    }
}
