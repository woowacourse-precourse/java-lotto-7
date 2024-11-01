package lotto.model;

import lotto.model.exception.LottoNumberInvalidException;

public class Lotto {

    private static final int NUMBER_SIZE = 6;

    private final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(LottoNumbers numbers) {
        if (!numbers.hasSize(NUMBER_SIZE)) {
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
