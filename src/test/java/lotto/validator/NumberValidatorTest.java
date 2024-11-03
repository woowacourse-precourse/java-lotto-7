package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {
    private final NumberValidator numberValidator = new NumberValidator();

    @Test
    @DisplayName("실패 - 공백이거나 빈 값일 경우")
    void 당첨_번호_검증_테스트_공백_빈값() {
        assertFalse(numberValidator.validateWinningNumbers(""));
        assertFalse(numberValidator.validateWinningNumbers(" "));
    }

    @Test
    @DisplayName("실패 - 숫자가 아닌 값, 범위가 벗어난 경우")
    void 당첨_번호_검증_테스트_숫자_아닌값() {
        assertFalse(numberValidator.validateWinningNumbers("1,45,4,5"));
        assertFalse(numberValidator.validateWinningNumbers("abcd"));
        assertFalse(numberValidator.validateWinningNumbers("1,2,3,4,5,46"));
        assertFalse(numberValidator.validateWinningNumbers("1,2,3,4,5,6,7"));
        assertFalse(numberValidator.validateWinningNumbers("1;2;3;4;5;6"));
        assertFalse(numberValidator.validateWinningNumbers("a,b,c,d,e,f"));
        assertFalse(numberValidator.validateWinningNumbers("1,2,3,4,5,-6"));
        assertFalse(numberValidator.validateWinningNumbers("1,2,3,4,5,5"));
        assertFalse(numberValidator.validateWinningNumbers("1,2,3,4,5,\t6"));
        assertFalse(numberValidator.validateWinningNumbers("1,2,3,4,5,@"));
        assertFalse(numberValidator.validateWinningNumbers("1,2,3,4,5,,6"));
    }

    @Test
    @DisplayName("성공 - 앞,뒤,중간에 공백이 있을 경우")
    void 당첨_번호_검증_테스트_맞는번호_앞뒤사이공백() {
        assertTrue(numberValidator.validateWinningNumbers("1,10,20,30,40,45"));
        assertTrue(numberValidator.validateWinningNumbers("1, 15, 25, 35,40 ,45 "));
        assertTrue(numberValidator.validateWinningNumbers("1,2,3,4,5,6,"));
    }

    // Bonus Number Tests
    @Test
    @DisplayName("실패 - 공백이거나 빈 값일 경우")
    void 보너스_번호_검증_테스트_공백_빈값() {
        assertFalse(numberValidator.validateBonusNumber(""));
        assertFalse(numberValidator.validateBonusNumber(" "));
    }

    @Test
    @DisplayName("실패 - 숫자가 아닌 값")
    void 보너스_번호_검증_테스트_숫자_아닌_값() {
        assertFalse(numberValidator.validateBonusNumber("abc"));
        assertFalse(numberValidator.validateBonusNumber("  abc"));
        assertFalse(numberValidator.validateBonusNumber(" @@"));
    }

    @Test
    @DisplayName("실패 - 범위가 벗어난 경우")
    void 보너스_번호_검증_테스트_범위_벗어남() {
        assertFalse(numberValidator.validateBonusNumber("-1"));
        assertFalse(numberValidator.validateBonusNumber("-45"));
        assertFalse(numberValidator.validateBonusNumber("46"));
        assertFalse(numberValidator.validateBonusNumber("0"));
    }

    @Test
    @DisplayName("성공 - 맞는 번호 앞,뒤,사이 공백")
    void 보너스_번호_검증_테스트_맞는번호_앞뒤사이공백() {
        assertTrue(numberValidator.validateBonusNumber("1"));
        assertTrue(numberValidator.validateBonusNumber(" 1"));
        assertTrue(numberValidator.validateBonusNumber("45"));
        assertTrue(numberValidator.validateBonusNumber("45 "));
        assertTrue(numberValidator.validateBonusNumber(" 4 5 "));
    }
}
