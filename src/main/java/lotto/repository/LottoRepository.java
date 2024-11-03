package lotto.repository;

import java.util.List;
import lotto.model.Lotto;

public interface LottoRepository {
    void generateRandomLottos(int purchaseAmount);
    int findTotalPrizeByWinningNumbersAndBonusNumber(List<Integer> winningNumbers, int bonusNumber);
    List<Lotto> findAll();
}
