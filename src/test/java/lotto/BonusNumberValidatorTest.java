package lotto;

import lotto.message.ErrorMessage;
import lotto.validator.BonusNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class BonusNumberValidatorTest {

    @Test
    @DisplayName("보너스 번호가 null 또는 빈 문자열이면 예외가 발생한다.")
    void validateBonusNumberWithNullOrEmpty() {
        String bonusNumber = "";

        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(bonusNumber, Set.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_NULL_OR_EMPTY.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    void validateBonusNumberWithNonNumeric() {
        String bonusNumber = "abc";

        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(bonusNumber, Set.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    void validateBonusNumberWithOutOfRange() {
        String bonusNumber = "46";

        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(bonusNumber, Set.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    void validateBonusNumberWithDuplicate() {
        String bonusNumber = "6";

        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(bonusNumber, Set.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
    }

    @Test
    @DisplayName("유효한 보너스 번호를 입력하면 검증에 성공한다.")
    void validateBonusNumberSuccessfully() {
        String bonusNumber = "7";

        int result = BonusNumberValidator.validateBonusNumber(bonusNumber, Set.of(1, 2, 3, 4, 5, 6));

        assertThat(result).isEqualTo(7);
    }
}