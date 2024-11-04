package lotto.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest {
    private final BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();

    @Test
    void bonusnumber로_빈문자열이_들어오면_예외처리한다(){
        assertThatThrownBy(() -> bonusNumberValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void bonusnumber가_숫자가_아니면_예외처리한다(){
        assertThatThrownBy(() -> bonusNumberValidator.validate("e"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
