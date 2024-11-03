package lotto.model;

import static lotto.common.ConstantsForTest.END_INCLUSIVE;
import static lotto.common.ConstantsForTest.START_INCLUSIVE;
import static lotto.common.ConstantsForTest.VALID_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.common.NumberGenerator;
import lotto.model.ErrorMessages.Lotto;
import lotto.model.lotto.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoValidatorTest {
    @Test
    @DisplayName("로또가 중복된 숫자들을 포함하는 경우 예외를 던진다.")
    void throwExceptionWhenLottoHasDuplicatedNumbers() {
        // given
        List<Integer> numbers = NumberGenerator.generateNumbersWithSizeAndRange(START_INCLUSIVE, VALID_SIZE - 1);
        numbers.add(numbers.get(0));

        // when & then
        assertThatThrownBy(() -> LottoValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Lotto.DUPLICATED);
    }

    @Test
    @DisplayName("로또가 잘못된 범위의 숫자를 포함하는 경우 예외를 던진다.")
    void throwExceptionWhenLottoHasInvalidRangeNumbers() {
        // given
        List<Integer> numbers = NumberGenerator.generateNumbersWithSizeAndRange(START_INCLUSIVE, VALID_SIZE - 1);
        numbers.add(END_INCLUSIVE + 1);

        // when & then
        assertThatThrownBy(() -> LottoValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Lotto.INVALID_RANGE);
    }

    @Test
    @DisplayName("로또가 유효하지 않은 개수를 갖는 경우 예외를 던진다.")
    void throwExceptionWhenLottoHasInvalidSize() {
        // given
        List<Integer> numbers = NumberGenerator.generateNumbersWithSizeAndRange(START_INCLUSIVE, VALID_SIZE - 1);

        // when & then
        assertThatThrownBy(() -> LottoValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Lotto.INVALID_SIZE);
    }
}
