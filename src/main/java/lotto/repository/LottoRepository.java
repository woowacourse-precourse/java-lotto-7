package lotto.repository;

import java.util.List;

public interface LottoRepository {
    void generateRandomLottos(int purchaseAmount);
    int findTotalPrizeByWinningNumbersAndBonusNumber(List<Integer> winningNumbers, int bonusNumber);
}
