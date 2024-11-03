package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoValidatorTest {

    LottoValidator validator;

    @Test
    void 값이_null이면_예외발생() {
        assertThatThrownBy(() -> {
            validator = new LottoValidator(null);
            validator.validateNotNull();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void 텍스트가_비어있으면_예외발생(String input) {
        assertThatThrownBy(() -> {
            validator = new LottoValidator(input);
            validator.validateNotEmpty();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd,123,qwe1", "asdf", "1,2.0,2", "0.0,33", "-37.0,11,999"})
    void 정수가_아니면_예외발생(String input) {
        assertThatThrownBy(() -> {
            validator = new LottoValidator(input);
            validator.validateWholeNumber();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,0,0", "1,3,-2", "-0,1,2,3", "-49183921,493021", "99999999999999999999999999999999999"})
    void 정수면_통과(String input) {
        validator = new LottoValidator(input);
        validator.validateWholeNumber();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,", "45,44,33,22,11,1,"})
    void 구분자로_끝나면_예외발생(String input) {
        assertThatThrownBy(() -> {
            validator = new LottoValidator(input);
            validator.validateEndingComma();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"99999999999999999999999999999999999,-99999999999999999999999999999999999"})
    void 정수_리스트_변환_불가능할경우_예외발생(String input) {
        assertThatThrownBy(() -> {
            validator = new LottoValidator(input);
            validator.validateListOfInteger();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"999999,-999999999,0,0,1,1", "0000000000000000000000000000000000000000000001,2,3"})
    void 정수_리스트_변환_가능한경우_통과(String input) {
        validator = new LottoValidator(input);
        validator.validateListOfInteger();
    }
}
