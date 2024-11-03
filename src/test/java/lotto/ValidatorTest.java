package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.validator.Validator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest
    @CsvSource(value = {"2000:1000", "0:1000"}, delimiter = ':')
    void isDividedTure(int num, int divider) {
        // when
        boolean result = Validator.isDivided(num, divider);

        // then
        assertThat(result)
                .isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"2500:1000", "123:1000"}, delimiter = ':')
    void isDividedFalse(int num, int divider) {
        // when
        boolean result = Validator.isDivided(num, divider);

        // then
        assertThat(result)
                .isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 7, 34, 45})
    void isBetweenTrue(int num) {
        // given
        int min = 1;
        int max = 45;

        // when
        boolean result = Validator.isBetween(min, num, max);

        // then
        assertThat(result)
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 47, 100})
    void isBetweenFalse(int num) {
        // given
        int min = 1;
        int max = 45;

        // when
        boolean result = Validator.isBetween(min, num, max);

        // then
        assertThat(result)
                .isFalse();
    }

    @Test
    void hasDuplicateNumberTrue() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // when
        boolean result = Validator.hasDuplicateNumber(numbers);

        // then
        assertThat(result)
                .isTrue();
    }

    @Test
    void hasDuplicateNumberFalse() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // when
        boolean result = Validator.hasDuplicateNumber(numbers);

        // then
        assertThat(result)
                .isFalse();
    }
}
