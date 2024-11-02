package lotto.service.lottoImpl;

import lotto.model.Lotto;
import lotto.model.LottoWinningNumber;

import java.util.List;

public interface ApplicationServiceImpl {
    List<Lotto> inputLottos(int tickets);

    LottoWinningNumber inputWinningNumber(List<Integer> winningNumbers, int bonusNumber);
}
