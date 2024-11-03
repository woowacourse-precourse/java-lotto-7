package lotto.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberInputValidatorTest {

    @Test
    @DisplayName("보너스 번호에 숫자가 아닌 문자가 포함된 경우")
    void 보너스_번호에_숫자가_아닌_문자가_포함_경우() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                BonusNumberInputValidator.validateBonusNumberInput("1a"));
    }
}
