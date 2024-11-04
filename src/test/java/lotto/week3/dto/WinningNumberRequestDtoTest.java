package lotto.week3.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumberRequestDtoTest {

    @Test
    void 당첨번호가_6개가_아닐때_예외발생() {
        // Given
        List<Integer> invalidWinningNumbers = Arrays.asList(1, 2, 3, 4, 5);  // 6개 미만

        // When & Then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new WinningNumberRequestDto(invalidWinningNumbers, 7)
        );
        assertEquals("[ERROR] 당첨 번호는 6자리 입니다. ", exception.getMessage());
    }

    @Test
    void 당첨번호에_중복이_있을때_예외발생() {
        // Given
        List<Integer> duplicateWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);  // 중복된 번호 포함

        // When & Then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new WinningNumberRequestDto(duplicateWinningNumbers, 7)
        );
        assertEquals("[ERROR] 당첨 번호는 1부터 45 사이의 고유한 숫자여햐 합니다.", exception.getMessage());
    }

    @Test
    void 당첨번호가_범위를_벗어날때_예외발생() {
        // Given
        List<Integer> outOfRangeWinningNumbers = Arrays.asList(0, 2, 3, 4, 5, 6);  // 범위 1 미만

        // When & Then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new WinningNumberRequestDto(outOfRangeWinningNumbers, 7)
        );
        assertEquals("[ERROR] 당첨 번호는 1부터 45 사이의 고유한 숫자여햐 합니다.", exception.getMessage());
    }

    @Test
    void 보너스번호가_당첨번호와_중복될때_예외발생() {
        // Given
        List<Integer> validWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int duplicateBonusNumber = 3;  // 당첨 번호와 중복

        // When & Then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new WinningNumberRequestDto(validWinningNumbers, duplicateBonusNumber)
        );
        assertEquals("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    void 보너스번호가_범위를_벗어날때_예외발생() {
        // Given
        List<Integer> validWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int outOfRangeBonusNumber = 46;  // 45를 초과

        // When & Then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new WinningNumberRequestDto(validWinningNumbers, outOfRangeBonusNumber)
        );
        assertEquals("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    void 올바른_당첨번호와_보너스번호로_생성_성공() {
        // Given
        List<Integer> validWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int validBonusNumber = 7;

        // When
        WinningNumberRequestDto dto = new WinningNumberRequestDto(validWinningNumbers, validBonusNumber);

        // Then
        assertEquals(validWinningNumbers, dto.getWinningNumbers());
        assertEquals(validBonusNumber, dto.getBonusNumber());
    }
}

