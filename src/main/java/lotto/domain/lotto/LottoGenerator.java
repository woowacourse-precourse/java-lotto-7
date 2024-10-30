package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.numbergenerator.IntegersGenerator;
import lotto.domain.numbergenerator.NumbersGenerator;

public class LottoGenerator {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int COUNT = 6;

    private final NumbersGenerator numbersGenerator;

    public LottoGenerator() {
        this.numbersGenerator = new IntegersGenerator();
    }

    public Lotto generate() {

        List<Integer> lottoNumbers = numbersGenerator.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
        List<LottoNumber> lotto = new ArrayList<>();

        for (Integer number : lottoNumbers) {
            lotto.add(new LottoNumber(number));
        }

        return new Lotto(lotto);
    }
}
