package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.generator.RandomIntegerListGenerator;
import lotto.domain.generator.RandomNumberListGenerator;

public class LottoGenerator {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int COUNT = 6;

    private final RandomNumberListGenerator randomNumberListGenerator;

    public LottoGenerator() {
        this.randomNumberListGenerator = new RandomIntegerListGenerator();
    }

    public Lotto generate() {

        List<Integer> lottoNumbers = randomNumberListGenerator.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE,
                COUNT);
        List<LottoNumber> lotto = new ArrayList<>();

        for (Integer number : lottoNumbers) {
            lotto.add(new LottoNumber(number));
        }

        return new Lotto(lotto);
    }
}
