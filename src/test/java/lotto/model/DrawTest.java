package lotto.model;

import lotto.validation.DrawValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DrawTest {
    @Test
    @DisplayName("당첨 번호가 6개가 아니면 예외 발생")
    void validateWinningNumbersCount_InvalidCount_ExceptionThrown() {
        List<Integer> numberGroup = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        assertThatThrownBy(() -> DrawValidation.validateWinningNumbersCount(numberGroup))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 중복되면 예외 발생")
    void validateDuplicatedNumber_DuplicatedNumber_ExceptionThrown() {
        List<Integer> numberGroup = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertThatThrownBy(() -> DrawValidation.validateDuplicatedNumber(numberGroup, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 범위를 벗어나면 예외 발생")
    void validateWinningNumberRange_InvalidNumberRange_ExceptionThrown() {
        List<Integer> numberGroup = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 46));

        assertThatThrownBy(() -> DrawValidation.validateWinningNumberRange(numberGroup))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 범위를 벗아나면 예외 발생")
    void validateBonusNumberRange_InvalidNumberRange_ExceptionThrown() {
        int bonusNumber = 46;

        assertThatThrownBy(() -> DrawValidation.validateBonusNumberRange(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
