package lotto.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BonusNumberInputHandlerTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", ",", "0.1"})
    void 보너스_숫자가_정수가_아니면_예외_발생(String bonusNumber) {
        assertThatThrownBy(() -> BonusNumberInputHandler.validateBonusNumberIsInteger(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 숫자는 정수여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void 보너스_숫자가_정수면_예외_없음(String bonusNumber) {
        assertDoesNotThrow(() -> BonusNumberInputHandler.validateBonusNumberIsInteger(bonusNumber));
    }
}
