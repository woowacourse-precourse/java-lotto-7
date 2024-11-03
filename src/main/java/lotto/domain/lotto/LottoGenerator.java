package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.utility.generator.RandomNumberListGenerator;
import lotto.domain.utility.sorting.Sorter;

public class LottoGenerator {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int COUNT = 6;

    private final RandomNumberListGenerator randomNumberListGenerator;
    private final Sorter sorter;

    public LottoGenerator(RandomNumberListGenerator randomNumberListGenerator, Sorter sorter) {
        this.randomNumberListGenerator = randomNumberListGenerator;
        this.sorter = sorter;
    }

    public Lotto generate() {

        List<Integer> lottoNumbers = randomNumberListGenerator.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE,
                COUNT);
        List<Integer> sortedLottoNumbers = sorter.sort(lottoNumbers);

        List<LottoNumber> numbers = new ArrayList<>();

        for (Integer number : sortedLottoNumbers) {
            numbers.add(new LottoNumber(number));
        }

        return new Lotto(numbers);
    }
}
