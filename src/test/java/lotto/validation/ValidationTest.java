package lotto.validation;

import lotto.exception.ExceptionMessage;
import lotto.exception.InvalidLottoException;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {
    @Test
    void isUniqueNumbers() {
        assertThatThrownBy(() -> Validation.isUniqueNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(InvalidLottoException.class)
                .hasMessage(ExceptionMessage.ERROR_DUPLICATE_NUMBER.getMessage());
    }

    @Test
    void checkDivisibleBy1000() {
        assertThatThrownBy(() -> Validation.checkDivisibleBy1000(1500))
                .isInstanceOf(InvalidLottoException.class)
                .hasMessage(ExceptionMessage.ERROR_NOT_DIVISIBLE_BY_1000.getMessage());
    }

    @Test
    void checkPositive() {
        assertThatThrownBy(() -> Validation.checkPositive(-1))
                .isInstanceOf(InvalidLottoException.class)
                .hasMessage(ExceptionMessage.ERROR_NEGATIVE_NUMBER.getMessage());
    }

    @Test
    void checkLottoNumberRange() {
        assertThatThrownBy(() -> Validation.checkLottoNumberRange(46))
                .isInstanceOf(InvalidLottoException.class)
                .hasMessage(ExceptionMessage.ERROR_NOT_IN_LOTTO_NUMBER_RANGE.getMessage());
    }

    @Test
    void checkLottoSize() {
        assertThatThrownBy(() -> Validation.checkLottoSize(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(InvalidLottoException.class)
                .hasMessage(ExceptionMessage.ERROR_LOTTO_SIZE_NOT_MATCHED.getMessage());
    }

    @Test
    void checkBonusNumberUnique() {
        assertThatThrownBy(() -> Validation.checkBonusNumberUnique(List.of(1, 2, 3, 4, 5), 5))
                .isInstanceOf(InvalidLottoException.class)
                .hasMessage(ExceptionMessage.ERROR_DUPLICATE_NUMBER.getMessage());
    }
}
