package lotto.application;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.WinResult;

public interface LottoResultUseCase {

    void createWinLotto(List<Integer> numbers, BonusNumber bonusNumber);

    void checkWinning();

    WinResult getWinResult();
}
