package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.random.CreateRandomNumbers;

public class Lottos {

    private static final int INITIAL_NUMBER = 0;

    private final List<Lotto> lottos;

    public Lottos(CreateRandomNumbers lottoNumberGenerator, int lottoCount) {
        this.lottos = createLottos(lottoNumberGenerator, lottoCount);
    }

    public List<Lotto> displayLottos() {
        return Collections.unmodifiableList(lottos);
    }

    private List<Lotto> createLottos(CreateRandomNumbers lottoNumberGenerator, int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = INITIAL_NUMBER; i < lottoCount; i++) {
            lottos.add(new Lotto(lottoNumberGenerator.getRandomNumbers()));
        }

        return lottos;
    }
}
