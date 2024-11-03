package lotto.application;

import java.util.List;
import lotto.domain.WinResult;

public interface LottoResultUseCase {

    void createWinLotto(List<Integer> numbers, int bonusNumber);

    void checkWinning();

    WinResult getWinResult();
}
