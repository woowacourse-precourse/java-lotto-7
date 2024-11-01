package lotto.service;

import lotto.domain.WinnerLotto;
import lotto.dto.LottoListDto;
import lotto.dto.MoneyDto;
import lotto.dto.ProfitRateResultDto;
import lotto.dto.WinnerStatusDto;

public interface LottoService {

    // 입력을 돈으로 반환하는 기능
    MoneyDto covertToMoney(String money);

    // 로또 개수만큼 로또를 생성해 리스트를 반환하는 기능
    LottoListDto generateLottoList(MoneyDto money);

    // 당첨번호 입력 WinnerNumber 반환
    // 이때 바로 등수 반환으로 하면 에러가 나도록 처리
    WinnerLotto addWinnerLotto(String winnerNumber);

    // 보너스 번호 입력 WinnerNumber 반환
    WinnerLotto addBonusNumber(WinnerLotto winnerLotto, String input);

    // 로또 리스트와 당첨번호를 통해 등수를 반환하는 기능
    // 보너스 번호가 들어가있지 확인하고 없으면 에러 반환
    WinnerStatusDto calculateWinnerStatus(LottoListDto lottoListDto, WinnerLotto winnerLotto);

    // 등수와 지금 가진 돈을 통해 수익률을 반환하는 기능
    ProfitRateResultDto calculateProfitRate(WinnerStatusDto winnerStatus, MoneyDto moneyDto);
}
