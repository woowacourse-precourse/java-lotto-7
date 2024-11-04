package lotto.model;

import static lotto.constant.LottoConstants.LOTTO_PRICE;

import java.util.List;

public final class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public long size() {
        return lottos.size();
    }

    public long amount() {
        return size() * LOTTO_PRICE;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
