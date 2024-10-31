package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.Utils.Validator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {""})
    public void 문자열이_비어있으면_True를_반환한다(String input) {
        boolean result = Validator.isEmptyString(input);
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\t", "0",})
    public void 문자열이_비어있지_않으면_False를_반환한다(String input) {
        boolean result = Validator.isEmptyString(input);
        assertThat(result).isFalse();
    }

}
