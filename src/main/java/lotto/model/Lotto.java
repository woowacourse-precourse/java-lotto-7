package lotto.model;

import lotto.model.exception.LottoNumberInvalidException;
import lotto.model.number.LottoNumber;
import lotto.model.number.LottoNumbers;
import lotto.model.number_generator.RandomNumberGenerator;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private final LottoNumbers numbers;

    private Lotto(LottoNumbers numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static Lotto generateBy(RandomNumberGenerator randomNumberGenerator) {
        return new Lotto(LottoNumbers.generateBy(LOTTO_NUMBER_SIZE, randomNumberGenerator));
    }

    private void validate(LottoNumbers numbers) {
        if (!numbers.hasSize(LOTTO_NUMBER_SIZE)) {
            String detail = String.format("로또 번호의 개수는 %d 개여야 합니다.", LOTTO_NUMBER_SIZE);
            throw LottoNumberInvalidException.lottoNumberSize(detail);
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
