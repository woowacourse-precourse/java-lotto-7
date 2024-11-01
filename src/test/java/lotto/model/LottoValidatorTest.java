package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.model.ErrorMessages.Lotto;
import lotto.model.lotto.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoValidatorTest {
    private static final int VALID_SIZE = 6;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;

    @Test
    @DisplayName("로또가 중복된 숫자들을 포함하는 경우 예외를 던진다.")
    void throwExceptionWhenLottoHasDuplicatedNumbers() {
        // given
        List<Integer> numbers = createNumbersWithOneLessSize();
        numbers.add(START_INCLUSIVE);

        // when & then
        assertThatThrownBy(() -> LottoValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Lotto.DUPLICATED);
    }

    @Test
    @DisplayName("로또가 잘못된 범위의 숫자를 포함하는 경우 예외를 던진다.")
    void throwExceptionWhenLottoHasInvalidRangeNumbers() {
        // given
        List<Integer> numbers = createNumbersWithOneLessSize();
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
        List<Integer> numbers = createNumbersWithOneLessSize();

        // when & then
        assertThatThrownBy(() -> LottoValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Lotto.INVALID_SIZE);
    }

    private List<Integer> createNumbersWithOneLessSize() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < VALID_SIZE - 1; i++) {
            numbers.add(START_INCLUSIVE + i);
        }
        return numbers;
    }
}
