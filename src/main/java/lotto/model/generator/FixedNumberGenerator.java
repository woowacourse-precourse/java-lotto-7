package lotto.model.generator;

import static lotto.constant.ErrorMessages.DUPLICATE_LOTTO_NUMBER_ERROR;
import static lotto.constant.ErrorMessages.LOTTO_NUMBER_COUNT_ERROR;
import static lotto.constant.LottoGameConfig.LOTTO_NUMBERS_COUNT;

import java.util.HashSet;
import java.util.List;
import lotto.util.LottoNumberValidator;

public class FixedNumberGenerator implements NumberGenerator {

    private final List<Integer> fixedNumbers;

    public FixedNumberGenerator(List<Integer> fixedNumbers) {
        validateUniqueLottoNumbers(fixedNumbers);
        validateLottoSize(fixedNumbers);
        validateNumbersInRange(fixedNumbers);
        this.fixedNumbers = fixedNumbers;
    }

    @Override
    public List<Integer> generateLottoNumbers() {
        return fixedNumbers;
    }

    private void validateUniqueLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_ERROR);
        }
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR);
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        numbers.forEach(LottoNumberValidator::validateNumberInRange);
    }
}