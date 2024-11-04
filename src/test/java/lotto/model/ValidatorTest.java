package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @Test
    void 구입금액_음수_예외_테스트() {
        assertThatThrownBy(() -> {
            Validator validator = new Validator();
            validator.validatePositiveAmount(-2000);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}