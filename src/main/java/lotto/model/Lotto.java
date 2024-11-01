package lotto.model;

import lotto.model.exception.LottoNumberInvalidException;

import java.util.List;

public class Lotto {

    private static final int NUMBER_SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw LottoNumberInvalidException.lottoNumberSize();
        }
        if (numbers.stream().distinct().count() != NUMBER_SIZE) {
            throw LottoNumberInvalidException.lottoNumberDuplicate();
        }
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public boolean containsLottoNumber(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }
}
