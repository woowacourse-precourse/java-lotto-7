package lotto;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos createLottos(Integer count) {
        return new Lottos(
                IntStream.range(0, count)
                        .mapToObj(i -> lottoGenerator.createLotto())
                        .collect(Collectors.toList()));
    }
}
