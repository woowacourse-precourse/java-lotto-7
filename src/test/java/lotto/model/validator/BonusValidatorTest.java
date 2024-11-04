package lotto.model.validator;

import lotto.exception.Exception;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BonusValidatorTest {

    @Test
    @DisplayName("보너스 번호 유효성 검사 - 중복된 번호")
    void validateBonusNumberDuplicate() {
        var winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int duplicateBonusNumber = 1;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            BonusValidator.validateBonusNumber(duplicateBonusNumber, winningNumbers);
        });

        assertEquals(Exception.DUPLICATE_BONUS_AND_WINNING_NUMBER.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호 유효성 검사 - 정상 케이스")
    void validateBonusNumberValid() {
        var winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int validBonusNumber = 7;

        assertDoesNotThrow(() -> {
            BonusValidator.validateBonusNumber(validBonusNumber, winningNumbers);
        });
    }

    @Test
    @DisplayName("보너스 번호 범위 유효성 검사")
    void validateBonusNumberRange() {
        var winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int outOfRangeBonusNumber = 46;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            BonusValidator.validateBonusNumber(outOfRangeBonusNumber, winningNumbers);
        });

        assertEquals(Exception.INVALID_NUMBER_RANGE.getMessage(), exception.getMessage());
    }
}
