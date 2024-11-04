package lotto.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LottoPurchaseValidatorTest {
    private final LottoPurchaseValidator lottoPurchaseValidator = new LottoPurchaseValidator();

    @Test
    void LottoPurchase로_빈문자열이_들어오면_예외처리한다(){
        assertThatThrownBy(() -> lottoPurchaseValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void LottoPurchase가_숫자가_아니면_예외처리한다(){
        assertThatThrownBy(() -> lottoPurchaseValidator.validate("e"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void LottoPurchase가_1000단위가_아니면_예외처리한다(){
        assertThatThrownBy(() -> lottoPurchaseValidator.validate("8500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
