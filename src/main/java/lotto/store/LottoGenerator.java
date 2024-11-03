package lotto.store;

import lotto.store.number.NumbersGenerator;

import java.util.List;

public class LottoGenerator {
    private final NumbersGenerator numbersGenerator;

    public LottoGenerator(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public Lotto random() {
        return new Lotto(toLottoNumbers(generateRandomNumbers()));
    }

    public static Lotto manual(List<Integer> pick) {
        return new Lotto(toLottoNumbers(pick));
    }

    private List<Integer> generateRandomNumbers() {
        return numbersGenerator.random(
                LottoNumber.MIN_LOTTO_NUMBER,
                LottoNumber.MAX_LOTTO_NUMBER,
                Lotto.LOTTO_SIZE
        );
    }

    private static List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::new).toList();
    }
}
