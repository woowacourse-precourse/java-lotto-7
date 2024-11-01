package lotto.domain.validator;

import static lotto.common.exception.ErrorMessages.*;

import java.util.List;

public class LottoValidator extends CompositeValidator {
    private static final int LENGTH = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final String INCORRECT_LENGTH = ERROR_TAG + String.format("로또 번호는 %d개여야 합니다.", LENGTH);
    private static final String INCORRECT_RANGE =
        ERROR_TAG + String.format("로또 번호는 %d ~ %d 사이여야 합니다", MIN_RANGE, MAX_RANGE);

    public LottoValidator() {
        this(List.of(new NonBlankValidator(), new NumberFormatValidator()));
    }

    public LottoValidator(List<InputValidator> inputValidators) {
        super(inputValidators);
    }

    @Override
    public void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        validateForEach(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LENGTH) {
            throw new IllegalArgumentException(INCORRECT_LENGTH);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int size = (int)numbers.stream().distinct().count();
        if (size != LENGTH) {
            throw new IllegalArgumentException(String.valueOf(DUPLICATED));
        }
    }

    private void validateForEach(List<Integer> numbers) {
        numbers.forEach(LottoValidator::validateRange);
    }

    private static void validateRange(int number) {
        if (MIN_RANGE > number || number > MAX_RANGE) {
            throw new IllegalArgumentException(INCORRECT_RANGE);
        }
    }
}
