package lotto.model;

import java.util.List;
import java.util.Map;

public interface LottoService {
    void buyLotto(int amount);

    List<Lotto> getLottoList();

    Rank checkWinning(Lotto lotto, Lotto winningNumbers, int bonusNumber);

    Map<Rank, Integer> calculateResults(Lotto winningNumbers, int bonusNumber);

    double calculateProfit(Map<Rank, Integer> results);
}
