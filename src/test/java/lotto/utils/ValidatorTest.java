package lotto.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 구입금액_유효한_금액() {
        assertEquals(8000, Validator.validatePurchaseAmount("8000"));
    }

    @Test
    void 구입금액_유효하지_않은_금액_예외발생() {
        assertThrows(IllegalArgumentException.class, () ->
                Validator.validatePurchaseAmount("1500"), ErrorMessage.INVALID_PURCHASE_AMOUNT);
    }

    @Test
    void 당첨번호_유효한_번호() {
        assertEquals("1,2,3,4,5,6", Validator.validateWinningNumbers("1,2,3,4,5,6"));
    }

    @Test
    void 당첨번호_유효하지_않은_개수_예외발생() {
        assertThrows(IllegalArgumentException.class, () ->
                Validator.validateWinningNumbers("1,2,3,4,5"), ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT);
    }

    @Test
    void 당첨번호_범위_초과_예외발생() {
        assertThrows(IllegalArgumentException.class, () ->
                Validator.validateWinningNumbers("1,2,3,4,5,46"), ErrorMessage.INVALID_LOTTO_NUMBER_RANGE);
    }

    @Test
    void 당첨번호_중복_예외발생() {
        assertThrows(IllegalArgumentException.class, () ->
                Validator.validateWinningNumbers("1,2,3,4,5,5"), ErrorMessage.DUPLICATE_LOTTO_NUMBER);
    }

    @Test
    void 보너스번호_유효한_번호() {
        assertEquals(7, Validator.validateBonusNumber("7"));
    }

    @Test
    void 보너스번호_범위_초과_예외발생() {
        assertThrows(IllegalArgumentException.class, () ->
                Validator.validateBonusNumber("50"), ErrorMessage.INVALID_BONUS_NUMBER_RANGE);
    }
}
