package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyValidatorTest {

    MoneyValidator validator;

    @Test
    void 값이_null이면_예외발생() {
        assertThatThrownBy(() -> {
            validator = new MoneyValidator(null);
            validator.validateNotNull();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void 텍스트가_비어있으면_예외발생(String input) {
        assertThatThrownBy(() -> {
            validator = new MoneyValidator(input);
            validator.validateNotEmpty();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"null", "asdf", "32.22", "0.0", "-37.0"})
    void 정수가_아니면_예외발생(String input) {
        assertThatThrownBy(() -> {
            validator = new MoneyValidator(input);
            validator.validateWholeNumber();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "123", "01", "-0", "-49183921", "99999999999999999999999999999999999"})
    void 정수면_통과(String input) {
        validator = new MoneyValidator(input);
        validator.validateWholeNumber();
    }

    @ParameterizedTest
    @ValueSource(strings = {"99999999999999999999999999999999999", "-99999999999999999999999999999999999"})
    void long_변환_불가능할경우_예외발생(String input) {
        assertThatThrownBy(() -> {
            validator = new MoneyValidator(input);
            validator.validateLong();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"999999999", "-9999999999999", "0000000000000000000000000000000000000000000001"})
    void long_변환_가능한경우_통과(String input) {
        validator = new MoneyValidator(input);
        validator.validateLong();
    }
}
