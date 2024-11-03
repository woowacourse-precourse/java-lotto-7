package lotto.util;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import lotto.error.ErrorType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberValidatorTest {

    private NumberValidator numberValidator;

    @BeforeEach
    void setUp() {
        numberValidator = NumberValidator.getInstance();
    }

    @DisplayName("숫자가 범위를 벗어나 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 100})
    void validateRangeTest(final int number) {
        //given
        final int min = 5;
        final int max = 45;

        //should
        assertThatIllegalArgumentException().isThrownBy(() -> numberValidator.validateRange(number, min, max))
                .withMessageContaining(ErrorType.EXCEEDED_NUMBER_RANGE);
    }

    @DisplayName("숫자 단위가 맞지 않아 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1100, 10, 1, 2100})
    void validateUnit(final int number) {
        //given
        final int unit = 1000;

        //should
        assertThatIllegalArgumentException().isThrownBy(() -> numberValidator.validateUnit(number, unit))
                .withMessageContaining(ErrorType.INVALID_MONEY_FORMAT);
    }

    @DisplayName("숫자가 숫자 리스트의 요소에 포함되어 있어 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void validateContains(final int number) {
        //given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        //should
        assertThatIllegalArgumentException().isThrownBy(() -> numberValidator.validateContains(numbers, number))
                .withMessageContaining(ErrorType.DUPLICATED_BONUS_NUMBER);
    }
}
