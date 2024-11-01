package lotto.validation;

import lotto.constants.ErrorMessageConstants;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberValidatorTest {
    @Test
    void 당첨_번호_개수_검증_테스트() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumbers(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.INVALID_WINNING_NUMBER_COUNT);
    }
}
