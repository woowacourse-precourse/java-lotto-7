package lotto.domain.generate;

import lotto.domain.entity.Lotto;
import lotto.domain.exception.LottoException;
import lotto.domain.exception.LottoNumberExceptionMessage;
import lotto.util.ValidLottoNumber;

import java.util.List;

public class FixedNumberGenerator implements LottoNumberGenerator {

    private final List<Integer> fixedNumbers;

    public FixedNumberGenerator(final List<Integer> fixedNumbers) {
        validate(fixedNumbers);
        this.fixedNumbers = fixedNumbers;
    }

    @Override
    public Lotto generateLotto() {
        return new Lotto(fixedNumbers);
    }

    private void validate(List<Integer> numbers) {
        if (ValidLottoNumber.isNotBoundedNumbers(numbers)) {
            throw new LottoException(LottoNumberExceptionMessage.NUMBER_BOUNDED_EXCEPTION);
        }

        if (ValidLottoNumber.isNotSixNumbers(numbers)) {
            throw new LottoException(LottoNumberExceptionMessage.NUMBERS_LENGTH_EXCEPTION);
        }

        if (ValidLottoNumber.isDuplicate(numbers)) {
            throw new LottoException(LottoNumberExceptionMessage.DUPLICATE_EXCEPTION);
        }
    }
}
