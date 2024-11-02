package lotto.dto;

import java.util.List;
import java.util.Objects;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.domain.Won;

public class LottoPaper {

    private final Won purchasePrice;
    private final List<Lotto> lottos;

    public LottoPaper(Won purchasePrice, List<Lotto> lottos) {
        this.purchasePrice = purchasePrice;
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    public RankResult match(WinningLotto winningLotto) {
        return new RankResult(toRanks(winningLotto));
    }

    private List<Rank> toRanks(WinningLotto winningLotto) {
        return this.lottos.stream().map(winningLotto::match).toList();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Won purchasePrice() {
        return purchasePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoPaper that = (LottoPaper) o;
        return Objects.equals(purchasePrice, that.purchasePrice) && Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchasePrice, lottos);
    }
}
