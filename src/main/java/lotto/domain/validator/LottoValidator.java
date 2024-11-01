package lotto.domain.validator;

import static lotto.common.constant.LottoConstant.*;
import static lotto.common.constant.ErrorMessages.*;

import java.util.List;

public class LottoValidator extends CompositeValidator {
    private static final String INCORRECT_LENGTH = ERROR_TAG + String.format("로또 번호는 %d개여야 합니다.", LENGTH.getValue());

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
        if (numbers.size() != LENGTH.getValue()) {
            throw new IllegalArgumentException(INCORRECT_LENGTH);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int size = (int)numbers.stream().distinct().count();
        if (size != LENGTH.getValue()) {
            throw new IllegalArgumentException(String.valueOf(DUPLICATED));
        }
    }

    private void validateForEach(List<Integer> numbers) {
        numbers.forEach(LottoValidator::validateRange);
    }

    private static void validateRange(int number) {
        if (MIN_RANGE.getValue() > number || number > MAX_RANGE.getValue()) {
            throw new IllegalArgumentException(String.valueOf(MUST_BE_IN_RANGE));
        }
    }
}
