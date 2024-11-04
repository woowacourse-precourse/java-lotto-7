package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBundle {
    private final List<Lotto> lottoBundle;

    public LottoBundle(List<Lotto> lottoBundle) {
        this.lottoBundle = new ArrayList<>(lottoBundle);
    }

    public List<Lotto> getLottoBundle() {
        return Collections.unmodifiableList(lottoBundle);
    }
}
