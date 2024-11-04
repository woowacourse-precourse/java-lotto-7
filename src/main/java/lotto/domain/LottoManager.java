package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoManager {

    private final List<Lotto> publishedLottos;

    private LottoManager(List<Lotto> publishedLottos) {
        this.publishedLottos = publishedLottos;
    }

    public static LottoManager from(int purchaseAmount){
        int lottoCount = purchaseAmount / 1000;
        List<Lotto> publishedLottos = LottoFactory.createLottos(lottoCount);
        return new LottoManager(publishedLottos);
    }

    public List<Lotto> getPublishedLottos() {
        return Collections.unmodifiableList(publishedLottos);
    }
}
