package lotto.model;

import lotto.model.exception.LottoNumberInvalidException;
import lotto.model.number.LottoNumber;
import lotto.model.number.LottoNumbers;
import lotto.model.number_generator.RandomNumberGenerator;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto generateBy(RandomNumberGenerator randomLottoNumberGenerator) {
        return new Lotto(LottoNumbers.generateBy(LOTTO_NUMBER_SIZE, randomLottoNumberGenerator));
    }

    private void validate(LottoNumbers numbers) {
        if (!numbers.hasSize(LOTTO_NUMBER_SIZE)) {
            throw LottoNumberInvalidException.lottoNumberSize();
        }
        if (!numbers.hasUniqueElements()) {
            throw LottoNumberInvalidException.lottoNumberDuplicate();
        }
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }

    public boolean containsLottoNumber(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }
}
