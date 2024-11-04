package lotto.model;

import java.util.List;
import java.util.Map;

public interface LottoService {
    void buyLotto(int amount);

    List<Lotto> getLottoList();

    Rank checkWinning(Lotto lotto, List<Integer> winningNumbers, int bonusNumber);

    Map<Rank, Integer> calculateResults(List<Integer> winningNumbers, int bonusNumber);

    double calculateProfit(Map<Rank, Integer> results);
}
