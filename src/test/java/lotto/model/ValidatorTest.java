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

    @Test
    void 구입금액_단위_예외_테스트() {
        assertThatThrownBy(() -> {
            Validator validator = new Validator();
            validator.validateAmountUnit(2500);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_범위_예외_테스트() {
        assertThatThrownBy(() -> {
            Validator validator = new Validator();
            validator.validateBonusRange(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}