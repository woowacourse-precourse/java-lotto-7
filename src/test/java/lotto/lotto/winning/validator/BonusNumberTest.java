package lotto.lotto.winning.validator;

import lotto.constant.ErrorMessage;
import lotto.lotto.validator.LottoValidator;
import lotto.lotto.winning.domain.BonusNumber;
import lotto.lotto.winning.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class BonusNumberTest {
    @Test
    @DisplayName("중복 테스트")
    void duplicateTest() {
        verifyExceptionForValidation("1,2,3,4,5,6", "6", ErrorMessage.DUPLICATE);
    }
    @Test
    @DisplayName("1 ~ 45까지 범위의 숫자가 아닌경우 예외가 발생한다")
    void withinRangeLottoNumberTest() {
        verifyExceptionForValidation("4,45,6,7,8,9", "46", ErrorMessage.WITHIN_RANGE);
    }
    private void verifyExceptionForValidation(String winningNumbers, String bonusNumber, ErrorMessage errorMessage) {
        WinningLotto winningLotto = WinningLotto.of(winningNumbers);
        BonusNumber bonus = BonusNumber.of(bonusNumber);
        assertThatThrownBy(
                () -> LottoValidator.bonusNumberValidate(bonus, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage.getMessage());
    }
}
