package lotto.domain.lotto;

import lotto.domain.lotto.factory.LottoFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private int lottoCount;
    private List<Lotto> lottos;


    public Lottos(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public void makeLottos(LottoFactory lottoFactory) {
        List<Lotto> lottos = Stream.generate(lottoFactory::create)
                .limit(lottoCount)
                .collect(Collectors.toList());
    }

}
