package lotto.validator;

import static lotto.constant.ErrorCode.INVALID_WINNIG_NUMBER_COUNT;
import static lotto.constant.LottoConstant.VALID_LOTTO_NUMBER_COUNT;

import java.util.List;
import lotto.view.OutputView;

public class LottoValidator {

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
            OutputView.printError(INVALID_WINNIG_NUMBER_COUNT.getMessage());
        }
    }
}
