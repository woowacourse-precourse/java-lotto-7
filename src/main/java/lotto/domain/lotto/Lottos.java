package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lotto.domain.buyer.PurchaseCount;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos of(final List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos generateRandomLottos(final PurchaseCount purchaseCount) {
        final List<Lotto> lottos = new ArrayList<>();

        for (int idx = 0; idx < purchaseCount.getPurchaseCount(); idx++) {
            lottos.add(LottoFactory.createRandomLotto());
        }

        return Lottos.of(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Lottos otherLottos = (Lottos) obj;
        return Objects.equals(lottos, otherLottos.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottos);
    }

    @Override
    public String toString() {
        StringBuilder purchasedLottos = new StringBuilder();

        for (Lotto lotto : lottos) {
            purchasedLottos.append(lotto.toString());
        }

        return purchasedLottos.toString();
    }
}
