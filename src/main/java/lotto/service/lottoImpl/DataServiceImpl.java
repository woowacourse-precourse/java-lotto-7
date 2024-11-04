package lotto.service.lottoImpl;

import lotto.model.Lotto;
import lotto.model.WinningNumber;

import java.util.List;

public interface DataServiceImpl {
    WinningNumber createWinningNumber(List<Integer> winningNumbers, int bonusNumber);

    List<Lotto> createLottos(int tickets);

    List<Integer> readWinningNumber(WinningNumber winningNumber);

    int readBonusNumber(WinningNumber winningNumber);
}
