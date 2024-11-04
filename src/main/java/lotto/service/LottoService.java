package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public interface LottoService {
    int calculateLottoCount(int purchasePrice);
    List<Lotto> createLottos(int purchasePrice);
    Map<LottoRank, Integer> calculateTotalWinnings(List<Lotto> lottos);
    double calculateRateOfReturn(Map<LottoRank, Integer> winningResults, int purchasePrice);
}
