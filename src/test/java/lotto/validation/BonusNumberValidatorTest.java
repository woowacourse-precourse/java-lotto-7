package lotto.validation;

import lotto.TestConstants;
import lotto.constants.ErrorMessageConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberValidatorTest {
    private static final int DUPLICATE_BONUS_NUMBER = 6;

    @DisplayName("보너스 번호 입력값이 null 또는 빈 값인 경우 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  "})
    void 보너스_번호_입력값이_null_또는_빈_값인_경우_예외_테스트(String invalidInput) {
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumberInput(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.EMPTY_BONUS_NUMBER);
    }

    @DisplayName("보너스 번호 입력값이 숫자가 아닌 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"a", "!", ","})
    void 보너스_번호_입력값이_숫자가_아닌_경우_예외_테스트(String invalidInput) {
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumberInput(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.INVALID_BONUS_NUMBER_FORMAT);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 보너스_번호_범위_검증_테스트(int invalidBonusNumber) {
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(TestConstants.VALID_WINNING_NUMBERS, invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.INVALID_BONUS_NUMBER_RANGE);
    }

    @Test
    void 보너스_번호_중복_검증_테스트() {
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(TestConstants.VALID_WINNING_NUMBERS, DUPLICATE_BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.INVALID_BONUS_NUMBER_DUPLICATE);
    }
}
