package lotto.controller;

import static lotto.exception.ErrorBase.BLANK_WINNING_NUMBERS;
import static lotto.exception.ErrorBase.BONUS_NUMBER_BLANK;
import static lotto.exception.ErrorBase.BONUS_NUMBER_NON_NUMERIC;
import static lotto.exception.ErrorBase.PURCHASE_AMOUNT_BLANK;
import static lotto.exception.ErrorBase.PURCHASE_AMOUNT_NON_NUMERIC;
import static lotto.exception.ErrorBase.WINNING_NUMBERS_NON_NUMERIC;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @Test
    public void 유효한_구입금액을_입력한다() {
        assertThat(InputValidator.validatePurchaseAmount("10000")).isEqualTo(10000L);
    }

    @Test
    public void 빈_문자열이면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_AMOUNT_BLANK.getMessage());
    }

    @Test
    public void 숫자가_아닌_입력시_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_AMOUNT_NON_NUMERIC.getMessage());
    }

    @Test
    public void 유효한_당첨번호를_입력한다() {
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(InputValidator.validateWinningLottos("1,2,3,4,5,6")).isEqualTo(expectedNumbers);
    }

    @Test
    public void 당첨번호에_빈_문자열이면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateWinningLottos("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BLANK_WINNING_NUMBERS.getMessage());
    }

    @Test
    public void 당첨번호에_숫자가_아닌_입력시_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateWinningLottos("1,2,abc,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBERS_NON_NUMERIC.getMessage());
    }

    @Test
    public void 유효한_보너스번호를_입력한다() {
        assertThat(InputValidator.validateBonusNumber("7")).isEqualTo(7);
    }

    @Test
    public void 보너스번호가_빈_문자열이면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_BLANK.getMessage());
    }

    @Test
    public void 보너스번호가_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_NON_NUMERIC.getMessage()  );
    }
}