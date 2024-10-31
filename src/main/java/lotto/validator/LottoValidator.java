package lotto.validator;

import static lotto.ErrorCode.INVALID_WINNIG_NUMBER_COUNT;

import java.util.List;

public class LottoValidator {

    private final int VALID_LOTTO_NUMBER_COUNT = 6;
    private final RangeValidator rangeValidator;
    private final DuplicateValidator<List<Integer>> duplicateValidator;

    public LottoValidator(final RangeValidator rangeValidator,
        final DuplicateValidator<List<Integer>> duplicateValidator) {
        this.rangeValidator = rangeValidator;
        this.duplicateValidator = duplicateValidator;
    }

    public void validate(final List<Integer> numbers) {
        numbers.forEach(rangeValidator::validateNumberRange);
        duplicateValidator.validateDuplicates(numbers);
        validateLottoNumberCount(numbers);
    }

    private void validateLottoNumberCount(final List<Integer> numbers) {
        if (numbers.size() != VALID_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNIG_NUMBER_COUNT.getMessage());
        }
    }
}
