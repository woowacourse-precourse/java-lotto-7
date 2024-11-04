package lotto.domain;

import lotto.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WinningNumberTest {

    @Test
    @DisplayName("정상적인 당첨 번호 생성 테스트")
    void testValidWinningNumberCreation() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(expectedNumbers, winningNumber.getWinningNumbers());
    }

    @Test
    @DisplayName("형식이 올바르지 않은 당첨 번호 입력에 대한 예외 발생 테스트")
    void testInvalidFormatWinningNumberThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new WinningNumber("1,2,3,4,5")
        );
        assertEquals(ErrorCode.WIN_NUMBER_PROPER.getErrorMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("중복되는 당첨 번호 입력에 대한 예외 발생 테스트")
    void testDuplicateWinningNumberThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new WinningNumber("1,2,3,4,5,5")
        );
        assertEquals(ErrorCode.WIN_NUMBER_DUPLICATE.getErrorMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("당첨 번호가 특정 숫자를 포함하는지 확인")
    void testContainsNumber() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        assertTrue(winningNumber.contains(3));
    }

    @Test
    @DisplayName("범위를 벗어난 숫자를 포함하는 당첨 번호 입력에 대한 예외 발생 테스트")
    void testOutOfRangeWinningNumberThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new WinningNumber("0,2,3,4,5,6")
        );
        assertEquals(ErrorCode.WIN_NUMBER_PROPER.getErrorMessage(), exception.getMessage());
    }
}
