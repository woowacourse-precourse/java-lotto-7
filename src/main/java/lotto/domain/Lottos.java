package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.wrapper.BonusNumber;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Rank> countMatchesWith(Lotto winningLotto, BonusNumber bonusNumber) {
        List<Rank> ranks = new ArrayList<>();

        lottos.forEach(lotto -> {
            int matchCount = matchCount(lotto, winningLotto);
            boolean bonusMatch = lotto.contains(bonusNumber.getNumber());
            ranks.add(Rank.valueOf(matchCount, bonusMatch));
        });

        return ranks;
    }

    private int matchCount(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto::contains)
                .count();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
