package lotto.validator;

import static lotto.validator.BonusNumberValidator.*;
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
}