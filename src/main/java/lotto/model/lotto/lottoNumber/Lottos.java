package lotto.model.lotto.lottoNumber;

import java.util.Collections;
import java.util.List;

public record Lottos(List<Lotto> lottos) {

    @Override
    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }
}
