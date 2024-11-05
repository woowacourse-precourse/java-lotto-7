package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberValidatorTest {

    @DisplayName("유효한 범위의 보너스 번호가 중복되지 않으면 예외가 발생하지 않음")
    @Test
    void validateBonusNumber_WhenValidAndNotDuplicate_ShouldNotThrowException() {
        int bonusNumber = 7;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatNoException().isThrownBy(() ->
                BonusNumberValidator.validateBonusNumber(bonusNumber, winningNumbers)
        );
    }

    @DisplayName("[ERROR] 보너스 번호가 범위를 벗어날 경우 예외 발생")
    @Test
    void validateBonusNumber_WhenOutOfRange_ShouldThrowException() {
        int bonusNumber = 46; // 범위를 벗어난 값
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() ->
                BonusNumberValidator.validateBonusNumber(bonusNumber, winningNumbers)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("[ERROR] 보너스 번호가 당첨 번호와 중복될 경우 예외 발생")
    @Test
    void validateBonusNumber_WhenDuplicate_ShouldThrowException() {
        int bonusNumber = 5; // 당첨 번호 중 하나와 중복
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() ->
                BonusNumberValidator.validateBonusNumber(bonusNumber, winningNumbers)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_DUPLICATE_INVALID.getMessage());
    }
    
}
