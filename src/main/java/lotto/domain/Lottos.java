package lotto.domain;

import java.util.List;
import static lotto.domain.LottoConstants.LOTTO_PRICE;

public class Lottos {
    private List<Lotto> lottos;
    private int lottoCount;

    public Lottos() {}

    public Lottos(List<Lotto> lottos, int purchasedPrice) {
        this.lottos = lottos;
        this.lottoCount = purchasedPrice / LOTTO_PRICE;
    }

    public Lottos(int purchasedPrice) {
        this.lottoCount = purchasedPrice / LOTTO_PRICE;
    }

}
