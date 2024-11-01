package lotto.service;

import lotto.dto.WinnerStatusDto;

public interface WinnerLottoService {

    void addWinnerLotto(String winnerNumber);

    void addBonusNumber(String input);

    WinnerStatusDto calculateStatus();
}
