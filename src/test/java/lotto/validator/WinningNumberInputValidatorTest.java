package lotto.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberInputValidatorTest {

    @Test
    @DisplayName("로또 당첨 번호 입력 중 숫자가 아닌 문자가 포함된 경우")
    void 로또_당첨_번호_입력_중_숫자가_아닌_문자가_포함된_경우() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> WinningNumberInputValidator.validateWinningNumberInput("1,2,3,a,4,5"));
    }

}
