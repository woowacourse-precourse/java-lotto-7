package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> lottos;

    Lottos(final List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
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
        Lottos otherLottos = (Lottos) obj;
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
