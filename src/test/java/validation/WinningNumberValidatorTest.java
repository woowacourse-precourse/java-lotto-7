package validation;

import java.util.List;
import lotto.validation.WinningNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;


public class WinningNumberValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"a,1", "a,b,c,d,e,f"})
    @NullAndEmptySource
    @DisplayName("구매 금액이 null이거나 빈 값, 또는 문자가 입력될 때 예외 처리")
    void NullOrEmptyOrStringWinningNumberTest(String input) {
        assertThatThrownBy(() -> {
            WinningNumberValidator.parseValidatedWinningNumber(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5"})
    @DisplayName("입력된 숫자가 6개가 아닐 때 예외 처리")
    void InvalidWinningNumberSizeTest(String input) {
        assertThatThrownBy(() -> {
            WinningNumberValidator.parseValidatedWinningNumber(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3,4,5,6", "1,2,3,4,5,66"})
    @DisplayName("입력된 숫자가 1~45사이의 숫자가 아닐 때 예외 처리")
    void InvalidWinningNumberRangeTest(String input) {
        assertThatThrownBy(() -> {
            WinningNumberValidator.parseValidatedWinningNumber(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,  2, 3,,4,5,6"})
    @DisplayName("공백이 있어도 유효한 숫자면 예외를 발생시키지 않는다.")
    void ValidWinningNumberLengthTest(String input) {
        assertThatNoException().isThrownBy(() -> {
            WinningNumberValidator.parseValidatedWinningNumber(input);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"0", "46", "abc"})
    @DisplayName("보너스 번호가 null이나 빈 값이거나, 범위를 넘거나, 숫자가 아닌 경우 예외 발생")
    void InvalidBonusNumberTest(String input) {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> {
            WinningNumberValidator.parseValidatedBonusNumber(input, winningNumber);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 예외 발생")
    void DuplicateBonusNumberTest(String input) {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> {
            WinningNumberValidator.parseValidatedBonusNumber(input, winningNumber);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }


}
