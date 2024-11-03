package lotto.model.lotto;

import java.util.Collections;
import java.util.List;

public record Lottos(List<Lotto> lottos) {

    @Override
    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }
}
