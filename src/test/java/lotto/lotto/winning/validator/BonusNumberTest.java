package lotto.lotto.winning.domain;

import lotto.lotto.validator.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class BonusNumberTest {
    @Test
    @DisplayName("중복 테스트")
    void duplicateTest() {
        verifyExceptionForValidation("1,2,3,4,5,6", "6", "[ERROR] 중복된 번호가 있습니다.");
    }
    @Test
    @DisplayName("1 ~ 45까지 범위의 숫자가 아닌경우 예외가 발생한다")
    void withinRangeLottoNumberTest() {
        verifyExceptionForValidation("4,45,6,7,8,9", "46", "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
    private void verifyExceptionForValidation(String winningNumbers, String bonusNumber, String expectedMessage) {
        WinningLotto winningLotto = WinningLotto.of(winningNumbers);
        BonusNumber bonus = BonusNumber.of(bonusNumber);
        assertThatThrownBy(
                () -> LottoValidator.bonusNumberValidate(bonus, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }
}
