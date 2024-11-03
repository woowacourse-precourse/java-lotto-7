package lotto.domain.lotto;

import java.util.List;
import lotto.domain.utility.generator.RandomNumberListGenerator;
import lotto.domain.utility.sorting.Sorter;

public class LottoBundle {

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
        for (int count = 0; count < lottoQuantity; count++) {
            lottoBundle.add(lottoGenerator.generate());
        }
    }

    public List<Lotto> getLottoBundle() {
        return lottoBundle;
    }
}
