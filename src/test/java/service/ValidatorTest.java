package service;

import exception.ErrorCode;
import model.Lotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    void 유효하지_않은_금액_예외_테스트() {
        assertThatThrownBy(() -> validator.validateNumber("1000j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_NUMBER.getErrorMessage());
    }

    @Test
    void 유효하지_않은_금액_1000의_배수_예외_테스트() {
        assertThatThrownBy(() -> validator.validateAmountCount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_PURCHASE_AMOUNT_UNIT.getErrorMessage());
    }

    @Test
    void 중복된_숫자_예외_테스트() {
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> validator.validateDuplicatedWinningNumber(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.DUPLICATED_WINNING_NUMBER.getErrorMessage());
    }

    @Test
    void 보너스_숫자_중복_예외_테스트() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int duplicateBonusNumber = 5;

        assertThatThrownBy(() -> validator.validateDuplicatedBonusNumber(duplicateBonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.DUPLICATED_BONUS_NUMBER.getErrorMessage());
    }

    @Test
    void 범위_초과_예외_테스트() {
        int outOfRangeNumber = 50;

        assertThatThrownBy(() -> validator.validateNumberRange(outOfRangeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.NUMBER_RANGE_LIMITATION.getErrorMessage());
    }

    @Test
    void 유효하지_않은_구분자_예외_테스트() {
        String invalidWinningNumber = "1-2-3-4-5-6";

        assertThatThrownBy(() -> validator.validateDelimiter(invalidWinningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_DELIMITER.getErrorMessage());
    }

    @Test
    void 빈값_예외_테스트() {
        assertThatThrownBy(() -> validator.validateEmpty(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_EMPTY.getErrorMessage());
    }
}

