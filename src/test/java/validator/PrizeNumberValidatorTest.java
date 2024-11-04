package validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.ErrorMessage;
import org.junit.jupiter.api.Test;

public class PrizeNumberValidatorTest {

    @Test
    void 당첨_번호가_범위에서_벗어난_경우() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 66);

        // when
        assertThatThrownBy(() -> PrizeNumberValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PRIZE_NUMBER_OUT_OF_RANGE); // then

    }

    @Test
    void 당첨_번호가_중복_되는_경우() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 3, 4, 5);

        // when
        assertThatThrownBy(() -> PrizeNumberValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PRIZE_NUMBER_DUPLICATION); // then
    }

    @Test
    void 당첨_번호_수가_6개가_아닌_경우() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when
        assertThatThrownBy(() -> PrizeNumberValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PRIZE_COUNT_OUT_OF_SIX); // then
    }

    @Test
    void 당첨_번호_적합성이_성공하는_경우() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 30);

        // when
        // then
        assertDoesNotThrow(() -> PrizeNumberValidator.validate(numbers));
    }
}
