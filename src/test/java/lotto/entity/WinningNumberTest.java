package lotto.entity;

import lotto.enums.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    // 당첨 번호 엔티티 ( WinningNumber.java ) 테스트

    @DisplayName("[WinningNumberTest] 당첨 번호에 빈 값이 입력되면 예외가 발생한다")
    @ParameterizedTest
    @NullSource
    void 당첨_번호에_빈_값이_입력되면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WINNING_NUMBER_IS_NULL.getMessage());
    }

    @DisplayName("[WinningNumberTest] 당첨 번호에 숫자 외의 값이 입력되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"asd", "1,23@$@", "12 12432", "@$%#!", "123@$12,./"})
    void 당첨_번호에_숫자_외의_값이_입력되면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WINNING_NUMBER_NOT_VALID_FORMAT.getMessage());
    }

    @DisplayName("[WinningNumberTest] 당첨 번호가 쉼표로 시작하거나 끝나면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {",,,,,", ",1,2,3,4,5,6", "1,2,3,4,5,6,", ",1,2,3,4,5,6,"})
    void 당첨_번호가_쉼표로_시작하거나_끝나면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WINNING_NUMBER_START_OR_END_WITH_COMMA.getMessage());
    }

    @DisplayName("[WinningNumberTest] 당첨 번호에 연속된 쉼표가 있다면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,,2,3,4,,5,6", "1,,,,,2,3,4,5,6", "1,,2,,3,,4,,5,,6", "1,2,3,4,,5,6"})
    void 당첨_번호에_연속된_쉼표가_있다면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WINNING_NUMBER_HAS_CONTINUOUS_COMMA.getMessage());
    }

    @DisplayName("[WinningNumberTest] 당첨 번호에 정수 범위를 벗어난 값을 입력하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"990909999999", "2147483648", "1111111111111111111", "9999999999999999"})
    void 당첨_번호에_정수_범위를_벗어난_값을_입력하면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WINNING_NUMBER_OUT_OF_RANGE.getMessage());
    }
}
