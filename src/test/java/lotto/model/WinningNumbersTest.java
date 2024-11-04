package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.exception.ExceptionMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersTest {
    @Test
    void 당첨_번호가_정상적으로_입력될_경우_정상_작동한다() {
        List<Integer> testNumbers = List.of(1, 2, 3, 4, 5, 6);
        int testBonusNumber = 7;
        WinningNumbers testWinningNumbers = new WinningNumbers(testNumbers, testBonusNumber);
    }

    @ParameterizedTest
    @MethodSource("invalidSizeOfWinningNumbers")
    void 당첨_번호_개수가_유효하지_않으면_예외가_발생한다(List<Integer> testNumbers, int testBonusNumber) {
        assertThatThrownBy(() -> new WinningNumbers(testNumbers, testBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_WINNING_NUMBER_SIZE.getMessage());
    }

    @ParameterizedTest
    @MethodSource("invalidRangeOfWinningNumbers")
    void 당첨_번호_범위가_유효하지_않으면_예외가_발생한다(List<Integer> testNumbers, int testBonusNumber) {
        assertThatThrownBy(() -> new WinningNumbers(testNumbers, testBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_WINNING_NUMBER_RANGE.getMessage());
    }

    @ParameterizedTest
    @MethodSource("duplicateWinningNumbers")
    void 당첨_번호가_중복되면_예외가_발생한다(List<Integer> testNumbers, int testBonusNumber) {
        assertThatThrownBy(() -> new WinningNumbers(testNumbers, testBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_WINNING_NUMBER.getMessage());
    }

    @ParameterizedTest
    @MethodSource("invalidRangeOfBonusNumber")
    void 보너스_번호_범위가_유효하지_않으면_예외가_발생한다(List<Integer> testNumbers, int testBonusNumber) {
        assertThatThrownBy(() -> new WinningNumbers(testNumbers, testBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
    }

    @ParameterizedTest
    @MethodSource("duplicateBonusNumber")
    void 보너스_번호가_중복되면_예외가_발생한다(List<Integer> testNumbers, int testBonusNumber) {
        assertThatThrownBy(() -> new WinningNumbers(testNumbers, testBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_BONUS_NUMBER.getMessage());
    }

    static Stream<Arguments> invalidSizeOfWinningNumbers() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6, 7), 8),
                Arguments.arguments(List.of(10, 20, 30, 40, 45, 16, 39), 32),
                Arguments.arguments(List.of(12, 22, 32, 42, 15, 36, 41), 24),
                Arguments.arguments(List.of(7, 9, 13, 18, 19, 20, 45), 7)
        );
    }

    static Stream<Arguments> invalidRangeOfWinningNumbers() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 46), 7),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 100), 7),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, -1), 7),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 0), 7)
        );
    }

    static Stream<Arguments> duplicateWinningNumbers() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 5), 7),
                Arguments.arguments(List.of(1, 1, 3, 4, 5, 6), 7),
                Arguments.arguments(List.of(10, 2, 10, 4, 5, 6), 7),
                Arguments.arguments(List.of(1, 24, 3, 24, 5, 6), 7)
        );
    }

    static Stream<Arguments> invalidRangeOfBonusNumber() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), 100),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 10), 0),
                Arguments.arguments(List.of(1, 2, 3, 4, 42, 6), -1),
                Arguments.arguments(List.of(1, 2, 31, 4, 5, 6), 47)
        );
    }

    static Stream<Arguments> duplicateBonusNumber() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 10), 10),
                Arguments.arguments(List.of(1, 2, 3, 4, 42, 6), 42),
                Arguments.arguments(List.of(1, 2, 31, 4, 5, 6), 31)
        );
    }

}