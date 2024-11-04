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
    @DisplayName("구입금액 유효성 검사 - 미입력")
    void moneyValidators_shouldThrowException_whenInputIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.moneyValidators(""));
        assertEquals(INVALID_EMPTY_INPUT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("구입금액 유효성 검사 - 숫자 형식 오류")
    void moneyValidators_shouldThrowException_whenInputIsNotNumeric() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.moneyValidators("abc"));
        assertEquals(POSITIVE_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("구입금액 유효성 검사 - 0인 경우")
    void moneyValidators_shouldThrowException_whenMoneyIsZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.moneyValidators("0"));
        assertEquals(INVALID_ZERO_AMOUNT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("구입금액 유효성 검사 - 구입금액이 로또 금액으로 나누어 떨어지지 않는 경우")
    void moneyValidators_shouldThrowException_whenAmountNotDivisibleByLottoPrice() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.moneyValidators("1100"));
        assertEquals(INVALID_AMOUNT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("구입금액 유효성 검사 - 유효한 경우")
    void moneyValidators_shouldNotThrowException_whenInputIsValid() {
        assertDoesNotThrow(() -> InputValidatorFacade.moneyValidators("8000"));
    }

    @Test
    @DisplayName("당첨 번호 유효성 검사 - 미입력")
    void winningNumValidators_shouldThrowException_whenInputIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.winningNumValidators(""));
        assertEquals(INVALID_EMPTY_INPUT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("당첨 번호 유효성 검사 - 숫자 형식 오류")
    void winningNumValidators_shouldThrowException_whenInputIsNotNumeric() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.winningNumValidators("1,a,3"));
        assertEquals(POSITIVE_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("당첨 번호 유효성 검사 - 범위 초과")
    void winningNumValidators_shouldThrowException_whenNumberOutOfRange() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.winningNumValidators("1,2,46"));
        assertEquals(String.format(NUMBER_OUT_OF_RANGE.getMessage(), 1, 45), exception.getMessage());
    }

    @Test
    @DisplayName("당첨 번호 유효성 검사 - 유효한 입력")
    void winningNumValidators_shouldNotThrowException_whenInputIsValid() {
        assertDoesNotThrow(() -> InputValidatorFacade.winningNumValidators("1,2,3,4,5,6"));
    }

    @Test
    @DisplayName("보너스 번호 유효성 검사 - 미입력")
    void bonusValidators_shouldThrowException_whenInputIsNull() {
        Lotto lotto = LottoFixture.create(1, 2, 3, 4, 5, 6);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.bonusValidators("", lotto));
        assertEquals(INVALID_EMPTY_INPUT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호 유효성 검사 - 숫자 형식 오류")
    void bonusValidators_shouldThrowException_whenInputIsNotNumeric() {
        Lotto lotto = LottoFixture.create(1, 2, 3, 4, 5, 6);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.bonusValidators("abc", lotto));
        assertEquals(POSITIVE_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호 유효성 검사 - 범위 초과")
    void bonusValidators_shouldThrowException_whenNumberOutOfRange() {
        Lotto lotto = LottoFixture.create(1, 2, 3, 4, 5, 6);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.bonusValidators("50", lotto));
        assertEquals(String.format(NUMBER_OUT_OF_RANGE.getMessage(), 1, 45), exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호 유효성 검사 - 중복 번호")
    void bonusValidators_shouldThrowException_whenNumberIsDuplicate() {
        Lotto lotto = LottoFixture.create(1, 2, 3, 4, 5, 6);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidatorFacade.bonusValidators("3", lotto));
        assertEquals(DUPLICATE_BONUS.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호 유효성 검사 - 유효한 입력")
    void bonusValidators_shouldNotThrowException_whenInputIsValid() {
        Lotto lotto = LottoFixture.create(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> InputValidatorFacade.bonusValidators("7", lotto));
    }
}
