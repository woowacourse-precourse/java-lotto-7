package lotto.domain;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.service.Generator;

public class LottoMachine {

    private final List<Lotto> lottos;

    private LottoMachine(int amount, Generator<Lotto> lottoGenerator) {
        lottos = IntStream.range(0, amount)
                .mapToObj(i -> lottoGenerator.generate())
                .collect(Collectors.toList());
    }

    public static LottoMachine buyLotto(int amount, Generator<Lotto> lottoGenerator) {
        return new LottoMachine(amount, lottoGenerator);
    }

    public List<Lotto>  getLottos() {
        return lottos;
    }

    public String toLottos() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

}
