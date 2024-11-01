package lotto;

import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BonusNumberTest {

    @DisplayName("보너스번호가_1보다_작으면_예외_발생")
    @Test
    void 보너스번호가_1보다_작으면_예외_발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateBonusNumber(0); // 1보다 작은 값
        });
        assertEquals("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

    @DisplayName("보너스번호가_45보다_크면_예외_발생")
    @Test
    void 보너스번호가_45보다_작으면_예외_발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateBonusNumber(50); // 1보다 작은 값
        });
        assertEquals("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

    @DisplayName("올바른_보너스번호_검증")
    @Test
    void 올바른_보너스번호_검증() {
        assertDoesNotThrow(() -> InputView.validateBonusNumber(10)); // 1부터 45 사이의 유효한 값
    }

}
