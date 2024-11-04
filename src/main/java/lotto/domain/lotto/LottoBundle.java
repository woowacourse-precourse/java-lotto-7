package lotto.domain.lotto;

import java.util.List;
import lotto.utility.generator.RandomNumberListGenerator;
import lotto.utility.sorting.Sorter;

public class LottoBundle {

    private static final int INITIAL_COUNT = 0;

    private final List<Lotto> lottoBundle;
    private final RandomNumberListGenerator randomNumberListGenerator;
    private final Sorter sorter;

    public LottoBundle(List<Lotto> lottoBundle, RandomNumberListGenerator randomNumberListGenerator, Sorter sorter) {
        this.lottoBundle = lottoBundle;
        this.randomNumberListGenerator = randomNumberListGenerator;
        this.sorter = sorter;
    }

    public void generate(int lottoQuantity) {
        LottoGenerator lottoGenerator = new LottoGenerator(randomNumberListGenerator, sorter);
        for (int count = INITIAL_COUNT; count < lottoQuantity; count++) {
            lottoBundle.add(lottoGenerator.generate());
        }
    }

    public List<Lotto> getLottoBundle() {
        return lottoBundle;
    }
}
