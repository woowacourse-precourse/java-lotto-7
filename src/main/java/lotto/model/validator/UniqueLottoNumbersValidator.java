package lotto.model.validator;

import static lotto.exception.InvalidAmountException.INVALID_AMOUNT_MESSAGE;
import static lotto.exception.InvalidLottoNumberException.DUPLICATE_LOTTO_NUMBERS;

import java.util.List;
import lotto.exception.InvalidLottoNumberException;

public class UniqueLottoNumbersValidator implements Validator {
    private final List<Integer> lottoNumbers;

    public UniqueLottoNumbersValidator(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public void validate() {
        long uniqueNumberCount = getUniqueNumberCount();

        if (uniqueNumberCount != lottoNumbers.size()) {
            throw new InvalidLottoNumberException(DUPLICATE_LOTTO_NUMBERS);
        }
    }

    private long getUniqueNumberCount() {
        return lottoNumbers.stream()
                .distinct()
                .count();
    }
}
