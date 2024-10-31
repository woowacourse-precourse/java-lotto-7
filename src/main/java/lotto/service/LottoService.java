package lotto.service;

import lotto.domain.LottoList;
import lotto.domain.Money;
import lotto.domain.ProfitRate;
import lotto.domain.WinnerNumber;
import lotto.domain.WinnerStatus;

public interface LottoService {

    // 입력을 돈으로 반환하는 기능
    Money covertToMoney(String money);

    // 로또 개수만큼 로또를 생성해 리스트를 반환하는 기능
    LottoList generateLottoList(Money money);

    // 당첨번호 입력 WinnerNumber 반환
    // 이때 바로 등수 반환으로 하면 에러가 나도록 처리
    WinnerNumber createWinnerNumber(String winnerNumber);

    // 보너스 번호 입력 WinnerNumber 반환
    WinnerNumber addBonusNumber(String bonusNumber);

    // 로또 리스트와 당첨번호를 통해 등수를 반환하는 기능
    // 보너스 번호가 들어가있지 확인하고 없으면 에러 반환
    WinnerStatus calculateWinnerStatus(LottoList lottoList, WinnerNumber winnerNumber);

    // 등수와 지금 가진 돈을 통해 수익률을 반환하는 기능
    ProfitRate calculateProfitRate(WinnerStatus winnerStatus, Money money);
}
