package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.config.LottoRule;
import lotto.model.Lotto;

public class InMemoryLottoRepository implements LottoRepository {
    private final List<Lotto> lottoStore;

    public InMemoryLottoRepository() {
        lottoStore = new ArrayList<>();
    }

    @Override
    public void generateRandomLottos(int purchaseAmount) {
        lottoStore.addAll(Lotto.buyLottos(purchaseAmount));
    }

    public Stream<LottoRule> generatePrizeStreamBy(List<Integer> winningNumbers, int bonusNumber) {
        return lottoStore.stream()
                .map(i -> LottoRule
                        .findByMatch(
                                i.countMatchNumber(winningNumbers),
                                i.hasBonus(bonusNumber)
                        )
                );
    }

    @Override
    public List<Lotto> findAll() {
        return lottoStore;
    }
}
