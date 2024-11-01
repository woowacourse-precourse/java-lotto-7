package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "5", "-7", "123"})
    void 숫자로_구성된_문자열인지_확인(String str) {
        // when
        boolean result = Validator.isNumeric(str);

        // then
        assertThat(result)
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"ab", "5d", "-e7", "?!@"})
    void 에러_숫자로_구성되지_않은_문자열(String str) {
        // when
        boolean result = Validator.isNumeric(str);

        // then
        assertThat(result)
                .isFalse();
    }
}
