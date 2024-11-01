package lotto.domain.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultRangeValidatorTest {

    @DisplayName("숫자가 1~45 범위 밖이면 true, 아니면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0, true", "46, true", "1, false", "45, false"})
    void returnTrueIfOutOfRange(Integer number, boolean expected) {
        DefaultRangeValidator rangeValidator = new DefaultRangeValidator();

        assertThat(rangeValidator.outOfRange(number)).isEqualTo(expected);
    }

}
