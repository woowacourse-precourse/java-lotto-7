package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.service.ValidatorService.validatePurchaseAmount;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorServiceTest {
    @Test
    @DisplayName("구매 금액이 유효하면 true, 유효하지 않다면 false 리턴해야 한다. ")
    void validatePurchaseAmountIsValid() {
        assertTrue(validatePurchaseAmount(5000));
        assertTrue(validatePurchaseAmount(1000));
        assertTrue(validatePurchaseAmount(100000));
        assertFalse(validatePurchaseAmount(500));
        assertFalse(validatePurchaseAmount(1100));
        assertFalse(validatePurchaseAmount(1000000));
    }


    @Test
    @DisplayName("winningNumbers 포맷이 유효한지 검증한다. ")
    void validateWinningNumbersFormatIsValid() {
        String[] winningNumbers = {"1", "2", "3", "4", "5", "6"};
        assertTrue(ValidatorService.validateWinningNumbersFormat(winningNumbers));
    }

    @Test
    @DisplayName("winningNumbers는 6개여야 한다. ")
    void validateWinningNumbersFormatWhenCountIsInvalid() {
        String[] winningNumbers = {"1", "2", "3", "4", "5"};
        assertThrows(IllegalArgumentException.class, () -> ValidatorService.validateWinningNumbersFormat(winningNumbers));
    }

    @Test
    @DisplayName("winningNumbers는 모두 숫자여야 한다.")
    void validateWinningNumbersFormatWhenInputIsNotANumber() {
        String[] winningNumbers = {"1", "2", "A", "4", "5", "6"};
        assertThrows(IllegalArgumentException.class, () -> ValidatorService.validateWinningNumbersFormat(winningNumbers));
    }

    @Test
    @DisplayName("올바를 숫자범위에 해당하면 true, 아니라면 false를 리턴한다. ")
    void isValidNumberInRange() {
        assertTrue(ValidatorService.isValidNumber(1));
        assertTrue(ValidatorService.isValidNumber(45));
        assertTrue(ValidatorService.isValidNumber(25));
        assertFalse(ValidatorService.isValidNumber(0));
        assertFalse(ValidatorService.isValidNumber(46));
        assertFalse(ValidatorService.isValidNumber(-10));
    }

    @Test
    @DisplayName("숫자들 간 중복이 존재하지 않으면 true, 존재하는 경우 false를 리턴한다. ")
    void isUniqueNumber() {
        int[] uniqueNumbers = {1, 2, 3, 4, 5, 6};
        assertTrue(ValidatorService.isUniqueNumber(uniqueNumbers));
        int[] nonUniqueNumbers = {1, 2, 3, 4, 4, 6};
        assertFalse(ValidatorService.isUniqueNumber(nonUniqueNumbers));
    }
}