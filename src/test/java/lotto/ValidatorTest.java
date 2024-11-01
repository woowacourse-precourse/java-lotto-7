package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.Utils.Validator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {""})
    public void 문자열이_비어있으면_True를_반환한다(String input) {
        boolean result = Validator.isEmpty(input);
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\t", "0",})
    public void 문자열이_비어있지_않으면_False를_반환한다(String input) {
        boolean result = Validator.isEmpty(input);
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\t", "\n"})
    public void 문자열이_공백문자만_있으면_True를_반환한다(String input) {
        boolean result = Validator.isBlank(input);
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {" 0", "1\t", "2\n"})
    public void 문자열이_공백아닌문자가_있으면_False를_반환한다(String input) {
        boolean result = Validator.isBlank(input);
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "111"})
    public void 문자열이_숫자만_있으면_False를_반환한다(String input) {
        boolean result = Validator.isNotNumeric(input);
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1원", "1.0", "", " "})
    public void 문자열이_숫자아닌_문자가_있으면_True를_반환한다(String input) {
        boolean result = Validator.isNotNumeric(input);
        assertThat(result).isTrue();
    }

}
