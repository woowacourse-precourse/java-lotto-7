package lotto.view.validator;

import static lotto.error.ErrorMessage.DUPLICATE_BONUS;
import static lotto.error.ErrorMessage.INVALID_AMOUNT;
import static lotto.error.ErrorMessage.INVALID_EMPTY_INPUT;
import static lotto.error.ErrorMessage.INVALID_ZERO_AMOUNT;
import static lotto.error.ErrorMessage.NUMBER_OUT_OF_RANGE;
import static lotto.error.ErrorMessage.POSITIVE_REQUIRED;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.fixture.LottoFixture;
import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorFacadeTest {

    @Test
    @DisplayName("구입금액 유효성 검사 - 미입력 시 예외가 발생한다.")
    void 구입금액_유효성_검사_미입력_시_예외_발생한다() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.moneyValidators(""));
        assertEquals(INVALID_EMPTY_INPUT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("구입금액 유효성 검사 - 양수 이외의 입력 시 예외가 발생한다.")
    void 구입금액_유효성_검사_양수_이외_입력_시_예외_발생한다() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.moneyValidators("abc"));
        assertEquals(POSITIVE_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("구입금액 유효성 검사 - 0을 입력하면 예외가 발생한다.")
    void 구입금액_유효성_검사_0_입력_시_예외_발생한다() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.moneyValidators("0"));
        assertEquals(INVALID_ZERO_AMOUNT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("구입금액 유효성 검사 - 구입금액이 로또 금액의 배수가 아닐 시 예외가 발생한다.")
    void 구입금액_유효성_검사_로또_금액_배수가_아닐_시_예외_발생한다() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.moneyValidators("1100"));
        assertEquals(INVALID_AMOUNT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("구입금액 유효성 검사 - 예외가 발생하지 않는다.")
    void 구입금액_유효성_검사_유효한_경우() {
        assertDoesNotThrow(() -> InputValidatorFacade.moneyValidators("8000"));
    }

    @Test
    @DisplayName("당첨 번호 유효성 검사 - 미입력 시 예외가 발생한다.")
    void 당첨_번호_유효성_검사_미입력_시_예외_발생한다() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.winningNumValidators(""));
        assertEquals(INVALID_EMPTY_INPUT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("당첨 번호 유효성 검사 - 양수 이외의 입력 시 예외가 발생한다.")
    void 당첨_번호_유효성_검사_양수_이외_입력_시_예외_발생한다() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.winningNumValidators("1,a,3"));
        assertEquals(POSITIVE_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("당첨 번호 유효성 검사 - 정해진 범위 이내 입력이 아닐 시 예외가 발생한다.")
    void 당첨_번호_유효성_검사_정해진_범위_벗어날_시_예외_발생한다() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.winningNumValidators("1,2,46"));
        assertEquals(String.format(NUMBER_OUT_OF_RANGE.getMessage(), 1, 45), exception.getMessage());
    }

    @Test
    @DisplayName("당첨 번호 유효성 검사 - 예외가 발생하지 않는다.")
    void 당첨_번호_유효성_검사_유효한_경우() {
        assertDoesNotThrow(() -> InputValidatorFacade.winningNumValidators("1,2,3,4,5,6"));
    }

    @Test
    @DisplayName("보너스 번호 유효성 검사 - 미입력 시 예외가 발생한다.")
    void 보너스_번호_유효성_검사_미입력_시_예외_발생한다() {
        Lotto lotto = LottoFixture.create(1, 2, 3, 4, 5, 6);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.bonusValidators("", lotto));
        assertEquals(INVALID_EMPTY_INPUT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호 유효성 검사 - 양수 이외의 입력 시 예외가 발생한다.")
    void 보너스_번호_유효성_검사_양수_이외_입력_시_예외_발생한다() {
        Lotto lotto = LottoFixture.create(1, 2, 3, 4, 5, 6);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.bonusValidators("abc", lotto));
        assertEquals(POSITIVE_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호 유효성 검사 - 정해진 범위 이내 입력이 아닐 시 예외가 발생한다.")
    void 보너스_번호_유효성_검사_정해진_범위_벗어날_시_예외_발생한다() {
        Lotto lotto = LottoFixture.create(1, 2, 3, 4, 5, 6);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.bonusValidators("50", lotto));
        assertEquals(String.format(NUMBER_OUT_OF_RANGE.getMessage(), 1, 45), exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호 유효성 검사 - 당첨 번호와 중복될 시 예외가 발생한다.")
    void 보너스_번호_유효성_검사_당첨_번호와_중복될_시_예외_발생한다() {
        Lotto lotto = LottoFixture.create(1, 2, 3, 4, 5, 6);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.bonusValidators("3", lotto));
        assertEquals(DUPLICATE_BONUS.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호 유효성 검사 - 예외가 발생하지 않는다.")
    void 보너스_번호_유효성_검사_유효한_경우() {
        Lotto lotto = LottoFixture.create(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> InputValidatorFacade.bonusValidators("7", lotto));
    }
}
