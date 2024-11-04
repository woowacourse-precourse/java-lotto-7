package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoIssue {

    private final List<Lotto> lottos;

    public LottoIssue(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
