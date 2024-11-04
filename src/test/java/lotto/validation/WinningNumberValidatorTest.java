package lotto.validation;

import lotto.TestConstants;
import lotto.constants.ErrorMessageConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberValidatorTest {
    private static final List<Integer> INVALID_COUNT_NUMBERS = List.of(1, 2, 3, 4, 5);
    private static final List<Integer> OUT_OF_RANGE_NUMBERS = List.of(1, 2, 3, 4, 5, 46);

    @DisplayName("당첨 번호 입력값이 비어있거나 공백인 경우 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "1, ,2", "1,,2"})
    void 당첨_번호_입력값이_비어있거나_공백인_경우_예외_테스트(String invalidInput) {
        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumbersInput(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.EMPTY_WINNING_NUMBERS);
    }

    @DisplayName("당첨 번호 입력값에 숫자가 아닌 값이 포함된 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,a,4,5,6", "1,2,!,4,5,6", "1,."})
    void 당첨_번호_입력값에_숫자가_아닌_값이_포함된_경우_예외_테스트(String invalidInput) {
        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumbersInput(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.INVALID_WINNING_NUMBER_FORMAT);
    }

    @Test
    void 당첨_번호_개수_검증_테스트() {
        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumbers(INVALID_COUNT_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.INVALID_WINNING_NUMBER_COUNT);
    }

    @Test
    void 당첨_번호_범위_검증_테스트() {
        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumbers(OUT_OF_RANGE_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.INVALID_WINNING_NUMBER_RANGE);
    }

    @Test
    void 당첨_번호_중복_검증_테스트() {
        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumbers(TestConstants.DUPLICATE_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.INVALID_WINNING_NUMBER_DUPLICATE);
    }
}
