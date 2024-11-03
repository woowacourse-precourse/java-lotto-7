package lotto.repository;

import java.util.List;
import java.util.stream.Stream;
import lotto.config.LottoRule;
import lotto.model.Lotto;

public interface LottoRepository {
    void generateRandomLottos(int purchaseAmount);
    Stream<LottoRule> generatePrizeStreamBy(List<Integer> winningNumbers, int bonusNumber);
    List<Lotto> findAll();
}
