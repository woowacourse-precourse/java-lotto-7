package lotto.util;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static lotto.util.ValidationUtils.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidationUtilsTest {
    @Test
    public void testValidateNotEmpty_ValidInput() {
        assertDoesNotThrow(() -> validateNotEmpty("1000"));
    }

    @Test
    public void testValidateNotEmpty_EmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> validateNotEmpty(""));
    }

    @Test
    public void testValidateIsNumber_ValidNumber() {
        assertDoesNotThrow(() -> validateIsNumber("1000"));
    }

    @Test
    public void testValidateIsNumber_InvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> validateIsNumber("abc"));
    }

    @Test
    public void testValidatePositive_PositiveValue() {
        assertDoesNotThrow(() -> validatePositive(1000));
    }

    @Test
    public void testValidatePositive_ZeroValue() {
        assertThrows(IllegalArgumentException.class, () -> validatePositive(0));
    }

    @Test
    public void testValidatePositive_NegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> validatePositive(-1000));
    }

    @Test
    public void testValidateThousandUnit_ValidUnit() {
        assertDoesNotThrow(() -> validateThousandUnit(1000));
    }

    @Test
    public void testValidateThousandUnit_InvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> validateThousandUnit(1500));
    }

    @Test
    public void testParseLong_InputExceedsLongMaxValue() {
        // 아주 큰 숫자 (long 범위를 초과하는 값)
        String largeNumber = "9223372036854775808"; // Long.MAX_VALUE + 1

        assertThrows(NumberFormatException.class, () -> Long.parseLong(largeNumber));
    }

    @Test
    public void testValidateWinningNumbers_ValidNumbers() {
        List<Integer> validNumbers = Arrays.asList(1, 15, 23, 34, 42, 45);
        assertDoesNotThrow(() -> validateWinningNumbers(validNumbers));
    }

    @Test
    public void testValidateWinningNumbers_SizeNotSix() {
        List<Integer> numbersWithFive = Arrays.asList(1, 15, 23, 34, 42);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validateWinningNumbers(numbersWithFive);
        });
        assertEquals("[ERROR] 당첨 번호는 6개여야 합니다.", exception.getMessage());
    }

    @Test
    public void testValidateWinningNumbers_DuplicateNumbers() {
        List<Integer> duplicateNumbers = Arrays.asList(1, 15, 15, 34, 42, 45);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validateWinningNumbers(duplicateNumbers);
        });
        assertEquals("[ERROR] 당첨 번호는 중복될 수 없습니다.", exception.getMessage());
    }

    @Test
    public void testValidateWinningNumbers_OutOfRangeNumbers() {
        // 1~45 범위를 벗어나는 숫자가 포함된 경우
        List<Integer> outOfRangeNumbers = Arrays.asList(1, 15, 23, 34, 46, 45);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validateWinningNumbers(outOfRangeNumbers);
        });
        assertEquals("[ERROR] 당첨 번호는 1~45 사이여야 합니다.", exception.getMessage());
    }

    @Test
    public void testValidateBonusNumber_ValidBonusNumber() {
        List<Integer> winningNumbers = Arrays.asList(1, 15, 23, 34, 42, 45);
        int validBonusNumber = 10;

        assertDoesNotThrow(() -> validateBonusNumber(validBonusNumber, winningNumbers));
    }

    @Test
    public void testValidateBonusNumber_OutOfRange() {
        List<Integer> winningNumbers = Arrays.asList(1, 15, 23, 34, 42, 45);
        int outOfRangeBonusNumber = 46;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validateBonusNumber(outOfRangeBonusNumber, winningNumbers);
        });
        assertEquals("[ERROR] 보너스 번호는 1~45 사이여야 합니다.", exception.getMessage());
    }

    @Test
    public void testValidateBonusNumber_DuplicateWithWinningNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 15, 23, 34, 42, 45);
        int duplicateBonusNumber = 15;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validateBonusNumber(duplicateBonusNumber, winningNumbers);
        });
        assertEquals("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.", exception.getMessage());
    }

    @Test
    public void testValidateBonusNumber_MinBoundary() {
        // 보너스 번호가 최소 경계값 (1)인 경우
        List<Integer> winningNumbers = Arrays.asList(5, 10, 15, 20, 25, 30);
        int minBoundaryBonusNumber = 1;

        assertDoesNotThrow(() -> validateBonusNumber(minBoundaryBonusNumber, winningNumbers));
    }

    @Test
    public void testValidateBonusNumber_MaxBoundary() {
        // 보너스 번호가 최대 경계값 (45)인 경우
        List<Integer> winningNumbers = Arrays.asList(5, 10, 15, 20, 25, 30);
        int maxBoundaryBonusNumber = 45;

        assertDoesNotThrow(() -> validateBonusNumber(maxBoundaryBonusNumber, winningNumbers));
    }

}
