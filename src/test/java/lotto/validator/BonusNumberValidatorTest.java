package lotto.validator;

import static lotto.exception.Exception.BONUS_NUMBER_DUPLICATED;
import static lotto.exception.Exception.BONUS_NUMBER_OUT_OF_RANGE;
import static lotto.validator.BonusNumberValidator.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest {
    @DisplayName("보너스 숫자 성공 테스트")
    @Test
    void validateBonusNumber_success() {
        int bonusNumber = 7;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> validate(bonusNumber, numbers));
    }

    @DisplayName("보너스 숫자가 1~45가 아닐 때 예외 테스트")
    @Test
    void validateBonusNumberRange_fail() {
        int bonusNumber = 56;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> validate(bonusNumber, numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("보너스 숫자가 당첨 숫자와 중복일 때 예외 테스트")
    @Test
    void validateLottoNumberDuplicates_fail() {
        int bonusNumber = 6;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> validate(bonusNumber, numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_DUPLICATED.getMessage());
    }
}