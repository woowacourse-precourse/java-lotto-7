package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.util.VisibleForTesting;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyValidatorTest {

    MoneyValidator validator;

    @VisibleForTesting
    @ParameterizedTest
    @ValueSource(strings = {"asdfsd", "0.0", "10.332", "-203.0"})
    void 정수가_들어오지_않으면_예외발생(String input) {
        assertThatThrownBy(() -> {
            validator = new MoneyValidator(input);
            validator.validateInteger();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @VisibleForTesting
    @ParameterizedTest
    @ValueSource(strings = {"12312", "0", "000", "-13021"})
    void 정수가_들어오면_통과(String input) {
        validator = new MoneyValidator(input);
        validator.validateInteger();
    }
}
