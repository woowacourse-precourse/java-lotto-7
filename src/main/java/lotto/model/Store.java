package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.controller.generator.NumberGenerator;

public class Store {

    private final NumberGenerator numberGenerator;

    public Store(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> purchaseLottos(final Money money) {
        final List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < money.calculateLottoCount(); i++) {
            purchasedLottos.add(new Lotto(numberGenerator.generate(Lotto.LOTTO_NUMBER_COUNT)));
        }
        return List.copyOf(purchasedLottos);
    }

    public Statistics calculateLottoResult(final WinningLotto winningLotto, final List<Lotto> lottos) {
        final List<Rank> ranks = lottos.stream()
                .map(lotto -> calculateRank(winningLotto, lotto))
                .toList();
        return new Statistics(ranks);
    }

    public Rank calculateRank(final WinningLotto winningLotto, final Lotto lotto) {
        return Rank.valueOf(winningLotto.matchCount(lotto), winningLotto.matchBonus(lotto));
    }
}
