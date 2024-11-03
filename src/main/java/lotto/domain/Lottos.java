package lotto.domain;

import java.util.List;
import java.util.stream.LongStream;

import lotto.domain.lotto.Lotto;
import lotto.random.LottoRandom;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos buy(LottoRandom lottoRandom, long buyCount) {
        return new Lottos(
            LongStream.range(0, buyCount)
                .mapToObj(i -> new Lotto(lottoRandom))
                .toList()
        );
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getAll() {
        return lottos;
    }
}
