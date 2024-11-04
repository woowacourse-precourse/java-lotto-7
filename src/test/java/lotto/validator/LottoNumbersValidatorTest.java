package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumbersValidatorTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private LottoNumbersValidator validator;

    public static Stream<Arguments> getInvalidWinningNumbersData() {
        return Stream.of(
            Arguments.arguments(List.of(1, 2, 3, 4)),
            Arguments.arguments(List.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @ParameterizedTest
    @MethodSource("getInvalidWinningNumbersData")
    void winningNumbersCountNotSixTest(List<Integer> value) {
        validator = new LottoNumbersValidator(value);

        assertThatThrownBy(() -> validator.validate())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void winningNumbersOutOfRangeTest(int value) {
        List<Integer> invalidNumbers = List.of(value, 2, 3, 4, 5, 6);
        validator = new LottoNumbersValidator(invalidNumbers);

        assertThatThrownBy(() -> validator.validate())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void winningNumbersDuplicatedTest() {
        List<Integer> duplicatedNumbers = List.of(1, 1, 2, 3, 4, 5);
        validator = new LottoNumbersValidator(duplicatedNumbers);

        assertThatThrownBy(() -> validator.validate())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }
}