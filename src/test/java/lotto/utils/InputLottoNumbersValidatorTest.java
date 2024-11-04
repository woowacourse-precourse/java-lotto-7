package lotto.utils;

import lotto.validator.InputLottoNumbersValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

class InputLottoNumbersValidatorTest {

    private InputLottoNumbersValidator validator;

    @BeforeEach
    void setUp() {
        validator = new InputLottoNumbersValidator();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또 번호가 1-45 범위를 벗어나면 예외를 발생시킨다")
    void validateNumberRange_shouldThrowExceptionWhenNumberOutOfRange(int invalidNumber) {
        List<Integer> invalidNumbers = Arrays.asList(invalidNumber, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> validator.validateWinningNumbers(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("중복된 로또 번호가 있으면 예외를 발생시킨다")
    void validateNoDuplicates_shouldThrowExceptionWhenDuplicatesExist() {
        List<Integer> duplicateNumbers = Arrays.asList(1, 1, 3, 4, 5, 6);
        assertThatThrownBy(() -> validator.validateWinningNumbers(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호에는 중복된 숫자가 있을 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("보너스 번호가 1-45 범위를 벗어나면 예외를 발생시킨다")
    void validateBonusNumberRange_shouldThrowExceptionWhenOutOfRange(int invalidBonusNumber) {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> validator.validateBonusNumber(invalidBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외를 발생시킨다")
    void validateNoDuplicateWithWinningNumbers_shouldThrowExceptionWhenDuplicateWithWinningNumber() {
        int duplicateBonusNumber = 6;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> validator.validateBonusNumber(duplicateBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}
