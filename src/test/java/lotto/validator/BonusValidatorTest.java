package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.view.message.ErrorMessage;
import org.junit.jupiter.api.Test;

class BonusValidatorTest {
    private final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @Test
    void 보너스_번호_빈_입력_예외_처리() {
        String input = "";

        assertThatThrownBy(() -> BonusValidator.validate(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.IS_EMPTY.getMessage());
    }

    @Test
    void 보너스_번호_숫자가_아닌_문자가_포함된_입력_예외_처리() {
        String input = "3o";

        assertThatThrownBy(() -> BonusValidator.validate(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_NUMERIC.getMessage());
    }

    @Test
    void 보너스_번호_1과_45_사이의_숫자가_아닌_입력_예외_처리() {
        String input = "50";

        assertThatThrownBy(() -> BonusValidator.validate(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_NUMBER_FORM_ONE_TO_FORTY_FIVE.getMessage());
    }

    @Test
    void 보너스_번호_중복된_숫자가_당첨_번호에_있는_입력_예외_처리() {
        String input = "2";

        assertThatThrownBy(() -> BonusValidator.validate(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.HAS_DUPLICATED_NUMBER.getMessage());
    }
}