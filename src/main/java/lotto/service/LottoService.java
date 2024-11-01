package lotto.service;

import lotto.domain.WinnerLotto;
import lotto.dto.LottoListDto;
import lotto.dto.MoneyDto;
import lotto.dto.ProfitRateResultDto;
import lotto.dto.WinnerStatusDto;

public interface LottoService {

    MoneyDto covertToMoney(String money);

    LottoListDto generateLottoList(MoneyDto money);

    WinnerLotto addWinnerLotto(String winnerNumber);

    WinnerLotto addBonusNumber(WinnerLotto winnerLotto, String input);

    WinnerStatusDto calculateWinnerStatus(LottoListDto lottoListDto, WinnerLotto winnerLotto);

    ProfitRateResultDto calculateProfitRate(WinnerStatusDto winnerStatus, MoneyDto moneyDto);
}
