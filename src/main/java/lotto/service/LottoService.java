package lotto.service;

import lotto.dto.LottoListDto;
import lotto.dto.MoneyDto;
import lotto.dto.ProfitRateResultDto;
import lotto.dto.WinnerStatusDto;

public interface LottoService {

    MoneyDto createMoney(String money);

    LottoListDto generateLottoList();

    void addWinnerLotto(String winnerNumber);

    void addBonusNumber(String input);

    WinnerStatusDto calculateWinnerStatus();

    ProfitRateResultDto calculateProfitRate();
}
