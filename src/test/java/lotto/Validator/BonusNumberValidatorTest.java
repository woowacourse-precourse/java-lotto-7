package lotto.Validator;

import static lotto.error.ErrorCode.BONUS_NUMBER_DUPLICATE;
import static lotto.error.ErrorCode.INVALID_BONUS_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberValidatorTest {
    private final List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

    @DisplayName("보너스 번호가 당첨 번호와 중복되지 않고 로또숫자범위 내라면 통과한다.")
    @ParameterizedTest
    @ValueSource(ints = {7,45})
    void validateBonusNumber_pass(int bonusNumber) {
        assertDoesNotThrow(() -> BonusNumberValidator.validateBonusNumber(bonusNumber, winningNumbers));
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외를 발생시킨다.")
    @Test
    void validateBonusNumber_duplicate() {
        int bonusNumber = 1;

        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_DUPLICATE.getMessage());
    }

    @DisplayName("보너스 번호가 로또숫자범위에서 벗어나면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {0,46})
    void validateBonusNumber_range(int bonusNumber) {

        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_BONUS_NUMBER_RANGE.getMessage());

    }

}