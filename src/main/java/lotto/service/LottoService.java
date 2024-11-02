package lotto.service;

import static lotto.util.RandomUtil.generateLottoNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;

public class LottoService {

    private final List<Lotto> lottos = new ArrayList<>();

    public void generateLottos(int lottoCount) {
        IntStream.range(0, lottoCount)
                .forEach(i -> lottos.add(new Lotto(generateLottoNumbers())));
    }
}
