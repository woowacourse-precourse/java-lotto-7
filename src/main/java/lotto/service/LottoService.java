package lotto.service;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.RankCount;

import java.util.List;

public interface LottoService {
    int calculateLottoCount(int price);
    List<Integer> pickLottoNumbers();
    List<RankCount> calculateWinningStatistics(Lottos lottos, Lotto winningNumbers, Integer bonusNumber);
    double calculateProfitability(List<RankCount> winningStatistics, int purchasePrice);
}
