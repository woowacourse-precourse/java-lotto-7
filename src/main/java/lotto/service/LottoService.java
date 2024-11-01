package lotto.service;

import lotto.domain.WinnerLotto;
import lotto.dto.LottoListDto;
import lotto.dto.MoneyDto;
import lotto.dto.ProfitRateResultDto;
import lotto.dto.WinnerStatusDto;

public interface LottoService {

    MoneyDto createMoney(String money);

    LottoListDto generateLottoList();

    WinnerLotto addWinnerLotto(String winnerNumber);

    WinnerLotto addBonusNumber(WinnerLotto winnerLotto, String input);

    WinnerStatusDto calculateWinnerStatus(LottoListDto lottoListDto, WinnerLotto winnerLotto);

    ProfitRateResultDto calculateProfitRate(WinnerStatusDto winnerStatus, MoneyDto moneyDto);
}
