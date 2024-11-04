package lotto.view;

import static lotto.common.exception.ExceptionMessages.INVALID_WINNING_NUMBER_FORMAT;
import static lotto.common.exception.ExceptionMessages.NONE_NUMERIC_INPUT;
import static lotto.common.exception.ExceptionMessages.WINNING_NUMBERS_CONTAINS_WHITESPACE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumbersInputTest {
    private WinningNumbersInput winningNumbersInput;

    @BeforeEach
    void setUp() {
        winningNumbersInput = new WinningNumbersInput();
    }

    @ParameterizedTest
    @MethodSource("provideNormalInput")
    void 올바른_당첨_번호_입력시_정상_동작(String[] input) {
        assertThatCode(() -> winningNumbersInput.validate(input)).doesNotThrowAnyException();
    }

    static Stream<Arguments> provideNormalInput() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "6"}),
                Arguments.of((Object) new String[]{"1", "2", "3", "5", "6", "45"})
        );
    }

    private void throwException(String[] input, String message) {
        assertThatThrownBy(() -> winningNumbersInput.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    void 빈_당첨번호_입력시_예외_발생() {
        String[] input = {""};
        throwException(input, INVALID_WINNING_NUMBER_FORMAT.getMessage());
    }

    @Test
    void 공백_포함_입력시_예외_발생() {
        String[] input = {" ", " 1", "2 ", " 3 "};
        throwException(input, WINNING_NUMBERS_CONTAINS_WHITESPACE.getMessage());
    }

    @Test
    void 숫자_아닌_값_입력시_예외_발생() {
        String[] input = {"-1", ":", "a"};
        throwException(input, NONE_NUMERIC_INPUT.getMessage());
    }
}
