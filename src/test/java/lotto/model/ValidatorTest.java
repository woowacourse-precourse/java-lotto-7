package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void 보너스_번호_중복_예외_테스트() {
        assertThatThrownBy(() -> {
            Validator validator = new Validator();
            validator.validateBonusDuplicate(List.of(1, 2, 3, 4, 5, 6, 44), 44);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}