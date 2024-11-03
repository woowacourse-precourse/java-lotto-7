package lotto.domain.buyer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoFactory;

public class BuyLottos {
    private final List<Lotto> lottos;

    private BuyLottos(final List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static BuyLottos of(final List<Lotto> lottos) {
        return new BuyLottos(lottos);
    }

    public static BuyLottos generateRandomLottos(final LottosCount LottosCount) {
        final List<Lotto> lottos = new ArrayList<>();

        for (int idx = 0; idx < LottosCount.getLottosCount(); idx++) {
            lottos.add(LottoFactory.createRandomLotto());
        }

        return BuyLottos.of(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getLottosSize() {
        return lottos.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BuyLottos otherLottos = (BuyLottos) obj;
        return Objects.equals(lottos, otherLottos.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottos);
    }

    @Override
    public String toString() {
        StringBuilder buyLottos = new StringBuilder();

        for (Lotto lotto : lottos) {
            buyLottos.append(lotto.toString());
        }

        return buyLottos.toString();
    }
}
