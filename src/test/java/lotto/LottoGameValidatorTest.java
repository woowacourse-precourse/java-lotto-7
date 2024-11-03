package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGameValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000", "0", "-123"})
    void checkIsNumericTure(String str) {
        // when
        boolean result = LottoGameValidator.checkIsNumeric(str);

        // then
        assertThat(result)
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000j", "asd", "^d(fd"})
    void checkIsNumericFalse(String str) {
        // when
        Throwable throwable = catchThrowable(() -> {
            LottoGameValidator.checkIsNumeric(str);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_MUST_NUMERIC.getMessage());
    }
}
