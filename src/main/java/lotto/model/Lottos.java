package lotto.model;

import static lotto.constant.LottoConstants.LOTTO_PRICE;

import java.util.List;

public final class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottosCount() {
        return lottos.size();
    }

    public int getAmount() {
        return getLottosCount() * LOTTO_PRICE;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
