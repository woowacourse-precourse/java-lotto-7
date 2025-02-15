package lotto.validation;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    void 금액이_정수일_경우_정상적으로_반환되는지_확인한다() {
        String input = "1000";
        int result = InputValidator.amountValidate(input);
        assertEquals(1000, result);
    }

    @Test
    void 금액이_정수가_아닐_경우_예외가_발생하는지_확인한다() {
        String input = "1000abc";
        assertThatThrownBy(() -> InputValidator.amountValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_정수_리스트로_정상_변환되는지_확인한다() {
        String input = "1, 2, 3, 4, 5, 6";
        List<Integer> result = InputValidator.listValidate(input);
        assertEquals(List.of(1, 2, 3, 4, 5, 6), result);
    }

    @Test
    void 로또_번호에_정수가_아닌_항목이_있을_경우_예외가_발생하는지_확인한다() {
        String input = "1, 2, a, 4, 5, 6";
        assertThatThrownBy(() -> InputValidator.listValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_정수일_경우_정상적으로_반환되는지_확인한다() {
        String input = "7";
        int result = InputValidator.bonusValidate(input);
        assertEquals(7, result);
    }

    @Test
    void 보너스_번호가_정수가_아닐_경우_예외가_발생하는지_확인한다() {
        String input = "bonus";
        assertThatThrownBy(() -> InputValidator.bonusValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
