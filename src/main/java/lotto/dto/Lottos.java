package lotto.dto;

import lotto.domain.Lotto;
import java.util.List;

public record Lottos(List<Lotto> lottos) {

    public Integer getLottosSize() {
        return lottos.size();
    }
}
