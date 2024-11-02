package lotto.service.lottoImpl;

import lotto.model.Lotto;
import lotto.model.LottoWinningNumber;

import java.util.List;

public interface DataServiceImpl {
    LottoWinningNumber createWinningNumber(List<Integer> winningNumbers, int bonusNumber);

    List<Lotto> createLottos(int tickets);

    List<Integer> readWinningNumber(LottoWinningNumber winningNumber);

    int readBonusNumber(LottoWinningNumber winningNumber);
}
