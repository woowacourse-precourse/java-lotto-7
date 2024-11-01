package lotto.validation;

import lotto.constants.ErrorMessageConstants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberValidatorTest {
    private static final List<Integer> INVALID_COUNT_NUMBERS = List.of(1, 2, 3, 4, 5);
    private static final List<Integer> OUT_OF_RANGE_NUMBERS = List.of(1, 2, 3, 4, 5, 46);
    private static final List<Integer> DUPLICATE_NUMBERS = List.of(1, 2, 3, 4, 5, 5);
    private static final List<Integer> VALID_WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private static final int DUPLICATE_BONUS_NUMBER = 6;

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
        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumbers(DUPLICATE_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.INVALID_WINNING_NUMBER_DUPLICATE);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 보너스_번호_범위_검증_테스트(int invalidBonusNumber) {
        assertThatThrownBy(() -> WinningNumberValidator.validateBonusNumber(VALID_WINNING_NUMBERS, invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.INVALID_BONUS_NUMBER_RANGE);
    }

    @Test
    void 보너스_번호_중복_검증_테스트() {
        assertThatThrownBy(() -> WinningNumberValidator.validateBonusNumber(VALID_WINNING_NUMBERS, DUPLICATE_BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.INVALID_BONUS_NUMBER_DUPLICATE);
    }
}
