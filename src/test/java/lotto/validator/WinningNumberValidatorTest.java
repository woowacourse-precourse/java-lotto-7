package lotto.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class WinningNumberValidatorTest {
    private final WinningNumberValidator winningNumberValidator = new WinningNumberValidator();

    @Test
    void winningNumber가_비었으면_예외처리한다(){
        assertThatThrownBy(() -> winningNumberValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void winningNumber가_숫자가_아니면_예외처리한다(){
        assertThatThrownBy(() -> winningNumberValidator.validate("e,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
