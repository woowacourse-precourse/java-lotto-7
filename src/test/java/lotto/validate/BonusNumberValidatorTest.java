package lotto.validate;

import static lotto.validate.BonusNumberValidator.validateBonusNumber;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "45"})
    void 올바른_보너스_번호_검증(String bonusNumber) {
        assertDoesNotThrow(() -> validateBonusNumber(bonusNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.5", "pobi", "도현"})
    void 잘못된_보너스_번호_타입_검증(String bonusNumber) {
        assertThatThrownBy(() -> validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_TYPE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "-1"})
    void 잘못된_보너스_번호_범위_검증(String bonusNumber) {
        assertThatThrownBy(() -> validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_RANGE.getMessage());
    }
}
