package lotto;

import java.util.List;
import java.util.stream.IntStream;

public class LottoManager {

    private final List<Lotto> lottos;

    public LottoManager(final int lottoAmount) {
        this.lottos = createLottos(lottoAmount);
    }

    private List<Lotto> createLottos(final int lottoAmount) {
        return IntStream.range(0, lottoAmount)
                .mapToObj(lotto -> LottoGenerator.generate())
                .toList();
    }


}
