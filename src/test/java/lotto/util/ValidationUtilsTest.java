package lotto.util;

import lotto.message.InputErrorMessage;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidationUtilsTest {

    @Test
    public void 유효하지_않은_구매금액_검증_테스트() {
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validateBuyAmount("-1000"));
        assertEquals(InputErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage(), exception1.getMessage());

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validateBuyAmount("0"));
        assertEquals(InputErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage(), exception2.getMessage());

        Exception exception3 = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validateBuyAmount(""));
        assertEquals(InputErrorMessage.EMPTY_PURCHASE_AMOUNT.getMessage(), exception3.getMessage());

        Exception exception4 = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validateBuyAmount("abcd"));
        assertEquals(InputErrorMessage.NON_NUMERIC_PURCHASE_AMOUNT.getMessage(), exception4.getMessage());
    }

    @Test
    public void 유효하지_않은_당첨번호_개수_검증_테스트() {
        Set<Integer> invalidNumbers = Set.of(1, 2, 3, 4, 5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validateWinningNumbers(invalidNumbers));
        assertEquals(InputErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage(), exception.getMessage());

        Set<Integer> invalidNumbers1 = Set.of(1, 2, 3, 4, 5, 6, 7);
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validateWinningNumbers(invalidNumbers1));
        assertEquals(InputErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage(), exception1.getMessage());
    }

    @Test
    public void 유효하지_않은_당첨번호_범위_검증_테스트() {
        Set<Integer> invalidNumbers = Set.of(0, 1, 2, 3, 4, 5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validateWinningNumbers(invalidNumbers));
        assertEquals(InputErrorMessage.INVALID_WINNING_NUMBER_RANGE.getMessage(), exception.getMessage());

        Set<Integer> invalidNumbers1 = Set.of(1, 2, 3, 4, 5, 46);
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validateWinningNumbers(invalidNumbers1));
        assertEquals(InputErrorMessage.INVALID_WINNING_NUMBER_RANGE.getMessage(), exception1.getMessage());
    }

    @Test
    public void 유효하지_않은_보너스번호_범위_검증_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validateBonusNumberRange(0));
        assertEquals(InputErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage(), exception.getMessage());

        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validateBonusNumberRange(46));
        assertEquals(InputErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage(), exception1.getMessage());
    }

    @Test
    public void 중복된_보너스번호_검증_테스트() {
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validateBonusNumberDuplication(6, winningNumbers));
        assertEquals(InputErrorMessage.INVALID_BONUS_NUMBER.getMessage(), exception.getMessage());
    }

    @Test
    public void 보너스번호_비숫자_검증_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.vaildateBonusNumberNotNumber("abcd"));
        assertEquals(InputErrorMessage.NON_NUMERIC_BONUS_NUMBER.getMessage(), exception.getMessage());

        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.vaildateBonusNumberNotNumber(""));
        assertEquals(InputErrorMessage.NON_NUMERIC_BONUS_NUMBER.getMessage(), exception1.getMessage());

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.vaildateBonusNumberNotNumber(","));
        assertEquals(InputErrorMessage.NON_NUMERIC_BONUS_NUMBER.getMessage(), exception2.getMessage());
    }

    @Test
    public void 잘못된_형식의_당첨번호_검증_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validateNumberFormat(""));
        assertEquals(InputErrorMessage.NULL_WINNING_NUMBER.getMessage(), exception.getMessage());
    }
}
