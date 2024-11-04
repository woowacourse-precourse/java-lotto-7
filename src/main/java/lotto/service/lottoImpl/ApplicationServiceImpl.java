package lotto.service.lottoImpl;

import lotto.model.Lotto;
import lotto.model.WinningNumber;

import java.util.List;

public interface ApplicationServiceImpl {
    List<Lotto> inputLottos(int tickets);

    WinningNumber inputWinningNumber(List<Integer> winningNumbers, int bonusNumber);
}
