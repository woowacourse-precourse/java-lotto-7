package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import lotto.error.LottoError;

class LottoNumberParserTest {

    @Test
    @DisplayName("유효한 입력이 주어지면 올바른 번호를 반환해야 한다.")
    void 유효한입력_올바른번호반환() {
        // Given
        String input = "1, 2, 3, 4, 5, 6";
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);

        // When
        List<Integer> actualNumbers = LottoNumberParser.parseWinningNumbers(input);

        // Then
        assertEquals(expectedNumbers, actualNumbers);
    }

    @Test
    @DisplayName("공백이 포함된 입력이 주어지면 올바른 번호를 반환해야 한다.")
    void 공백포함입력_올바른번호반환() {
        // Given
        String input = " 7 ,  8 ,  9 ,  10 , 11 , 12 ";
        List<Integer> expectedNumbers = List.of(7, 8, 9, 10, 11, 12);

        // When
        List<Integer> actualNumbers = LottoNumberParser.parseWinningNumbers(input);

        // Then
        assertEquals(expectedNumbers, actualNumbers);
    }

    @Test
    @DisplayName("유효하지 않은 번호가 포함된 입력이 주어지면 예외를 발생시켜야 한다.")
    void 유효하지않은번호포함입력_예외발생() {
        // Given
        String input = "1, 2, 3, 4, 5, 60";
        String expectedMessage = LottoError.INVALID_NUMBER_RANGE.getMessage();

        // When & Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoNumberParser.parseWinningNumbers(input);
        });
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("중복된 번호가 포함된 입력이 주어지면 예외를 발생시켜야 한다.")
    void 중복번호포함입력_예외발생() {
        // Given
        String input = "1, 2, 3, 4, 5, 5";
        String expectedMessage = LottoError.DUPLICATE_NUMBER.getMessage();

        // When & Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoNumberParser.parseWinningNumbers(input);
        });
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("너무 많은 번호가 포함된 입력이 주어지면 예외를 발생시켜야 한다.")
    void 너무많은번호포함입력_예외발생() {
        // Given
        String input = "1, 2, 3, 4, 5, 6, 7";
        String expectedMessage = LottoError.INVALID_NUMBER_COUNT.getMessage(); // 예외 메시지를 실제 메시지에 맞게 수정합니다.

        // When & Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoNumberParser.parseWinningNumbers(input);
        });
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
