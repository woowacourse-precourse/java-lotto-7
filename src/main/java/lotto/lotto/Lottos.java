package lotto.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos purchase(LottoAmount lottoAmount, NumberGenerator numberGenerator) {
        List<Lotto> lottos = new ArrayList<>();
        int purchaseLottoCount = lottoAmount.getPurchaseLottoCount();
        for (int i = 0; i < purchaseLottoCount; i++) {
            lottos.add(new Lotto(numberGenerator.generate()));
        }
        return new Lottos(lottos);
    }

    public List<List<Integer>> getLottoValues() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .toList();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
