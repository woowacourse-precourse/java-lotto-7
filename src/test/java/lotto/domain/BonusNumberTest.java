package lotto.domain;


import lotto.ErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusNumberTest {

    private WinningNumber winningNumber;

    @BeforeEach
    void setUp() {
        winningNumber = new WinningNumber("1,2,3,4,5,6");
    }

    @Test
    @DisplayName("정상적인 보너스 번호 생성 테스트")
    void testValidBonusNumberCreation() {
        BonusNumber bonusNumber = new BonusNumber("7", winningNumber);
        assertEquals(7, bonusNumber.getBonusNumber());
    }

    @Test
    @DisplayName("숫자가 아닌 입력에 대해 예외 발생 테스트")
    void testNonNumericInputThrowsException() {
        Exception exception = assertThrows(NumberFormatException.class, () ->
                new BonusNumber("abc", winningNumber)
        );
        assertEquals(ErrorCode.INPUT_POSITIVE_INTEGER.getErrorMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("범위를 벗어난 보너스 번호에 대해 예외 발생 테스트")
    void testBonusNumberOutOfRangeThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new BonusNumber("50", winningNumber)
        );
        assertEquals(ErrorCode.BONUS_NUMBER_IN_RANGE.getErrorMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("당첨 번호와 중복되는 보너스 번호에 대해 예외 발생 테스트")
    void testBonusNumberDuplicateThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new BonusNumber("1", winningNumber)
        );
        assertEquals(ErrorCode.BONUS_NUMBER_DUPLICATE.getErrorMessage(), exception.getMessage());
    }
}
