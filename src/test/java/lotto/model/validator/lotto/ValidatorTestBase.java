package lotto.model.validator.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.exception.InvalidLottoNumberException;
import org.junit.jupiter.api.Test;

abstract class ValidatorTestBase {
    protected abstract BaseNumberValidator createValidator(List<Integer> winNumbers, Integer bonusNumber);

    @Test
    void 번호가_유효한_범위에_있으면_예외가_발생하지_않는다() {
        List<Integer> inRangeNumbers = List.of(1, 2, 3, 4, 5, 6);
        createValidator(inRangeNumbers, 7);
        assertDoesNotThrow(() -> createValidator(inRangeNumbers, 7).validate());
    }

    @Test
    void 번호가_유효한_범위를_벗어나면_예외가_발생한다() {
        List<Integer> outOfRangeNumbers = List.of(0, 46, 10, 20, 30, 40);
        createValidator(outOfRangeNumbers, 7);
        assertThatThrownBy(() -> createValidator(outOfRangeNumbers, 7).validate())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InvalidLottoNumberException.OUT_OF_RANGE_NUMBER);
    }

    protected void validateDuplicates(List<Integer> numbers, Integer bonusNumber, String expectedMessage) {
        createValidator(numbers, bonusNumber);
        assertThatThrownBy(() -> createValidator(numbers, bonusNumber).validate())
                .isInstanceOf(InvalidLottoNumberException.class)
                .hasMessage(expectedMessage);
    }
}