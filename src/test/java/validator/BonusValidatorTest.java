package validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.ErrorMessage;
import org.junit.jupiter.api.Test;

class BonusValidatorTest {

    @Test
    void 보너스_번호와_당첨_번호가_중복되는_경우() {
        // given
        Integer bonus = 4;
        List<Integer> prizeNumbers = List.of(1, 2, 3, 4, 5, 44);

        // when
        assertThatThrownBy(() -> BonusValidator.validate(bonus, prizeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_AND_PRIZE_NUMBER_DUPLICATION); // then
    }

    @Test
    void 보너스_번호가_허용된_범위를_벗어난_경우() {
        // given
        Integer bonus = 50;
        List<Integer> prizeNumbers = List.of(1, 2, 3, 4, 5, 44);

        // when
        assertThatThrownBy(() -> BonusValidator.validate(bonus, prizeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE); // then
    }
}
