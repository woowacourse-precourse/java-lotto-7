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

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 보너스_숫자가_1에서_45_사이의_값이_아니면_예외_발생(int bonusNumber) {
        assertThatThrownBy(() -> BonusNumberInputHandler.validateBonusNumberRange(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 숫자는 1에서 45 사이의 값이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 보너스_숫자가_1에서_45_사이의_값이면_예외_없음(int bonusNumber) {
        assertDoesNotThrow(() -> BonusNumberInputHandler.validateBonusNumberRange(bonusNumber));
    }
}
