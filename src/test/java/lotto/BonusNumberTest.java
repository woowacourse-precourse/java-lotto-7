package lotto;

import lotto.validator.BonusNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BonusNumberTest {

    @DisplayName("보너스번호가_1보다_작으면_예외_발생")
    @Test
    void 보너스번호가_1보다_작으면_예외_발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BonusNumberValidator.validateBonusNumberRange(0); // 1보다 작은 값
        });
        assertEquals("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

    @DisplayName("보너스번호가_45보다_크면_예외_발생")
    @Test
    void 보너스번호가_45보다_작으면_예외_발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BonusNumberValidator.validateBonusNumberRange(50); // 1보다 작은 값
        });
        assertEquals("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

    @DisplayName("보너스번호가_숫자가_아닌_값을_입력하면_예외_발생")
    @Test
    void 보너스번호가_숫자가_아닌_값을_입력하면_예외_발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BonusNumberValidator.validateBonusNumberIsNumeric("aaa"); // 1보다 작은 값
        });
        assertEquals("[ERROR] 보너스 번호는 숫자여야 합니다.", exception.getMessage());
    }

    @DisplayName("보너스번호가_당첨번호와_중복되면_예외_발생")
    @Test
    void 보너스번호가_당첨번호와_중복되면_예외_발생() {
        // Given: 당첨 번호와 보너스 번호 설정
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6); // 예시 당첨 번호
        int bonusNumber = 1; // 중복되는 보너스 번호

        // When & Then: 보너스 번호 검증 시 예외 발생
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BonusNumberValidator.validateBonusNumberNotDuplicate(bonusNumber, winningNumbers);
        });
        assertEquals("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.", exception.getMessage());
    }

    @DisplayName("올바른_보너스번호_검증")
    @Test
    void 올바른_보너스번호_검증() {
        assertDoesNotThrow(() -> BonusNumberValidator.validateBonusNumberRange(10)); // 1부터 45 사이의 유효한 값
    }

}
