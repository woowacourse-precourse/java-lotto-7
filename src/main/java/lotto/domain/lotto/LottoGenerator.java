package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.generator.RandomIntegerListGenerator;
import lotto.domain.generator.RandomNumberListGenerator;
import lotto.domain.sorting.AscendingSorter;
import lotto.domain.sorting.Sorter;

public class LottoGenerator {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int COUNT = 6;

    private final RandomNumberListGenerator randomNumberListGenerator;
    private final Sorter sorter;

    public LottoGenerator(RandomNumberListGenerator randomNumberListGenerator, Sorter sorter) {
        this.randomNumberListGenerator = new RandomIntegerListGenerator();
        this.sorter = new AscendingSorter();
    }

    public Lotto generate() {

        List<Integer> lottoNumbers = randomNumberListGenerator.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE,
                COUNT);
        sorter.sort(lottoNumbers);

        List<LottoNumber> lotto = new ArrayList<>();

        for (Integer number : lottoNumbers) {
            lotto.add(new LottoNumber(number));
        }

        return new Lotto(lotto);
    }
}
