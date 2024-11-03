package lotto.viewHandler.validator;

import lotto.viewHandler.exception.NotLottoNumberRange;
import lotto.viewHandler.validator.validatorImpl.LottoNumberRangeValidator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberRangeValidatorTest {
    private final LottoNumberRangeValidator lottoNumberRangeValidator;

    public LottoNumberRangeValidatorTest() {
        this.lottoNumberRangeValidator = new LottoNumberRangeValidator();
    }

    @Test
    void 로또_범위_확인() {
        lottoNumberRangeValidator.validate(23);
    }

    @Test
    void 음수_에러_확인() {
        assertThatThrownBy(() -> {
            lottoNumberRangeValidator.validate(-1);
        }).isInstanceOf(NotLottoNumberRange.class);
    }

    @Test
    void 로또_범위_초과_확인() {
        assertThatThrownBy(() -> {
            lottoNumberRangeValidator.validate(46);
        }).isInstanceOf(NotLottoNumberRange.class);
    }

    @Test
    void 로또_범위_0_확인() {
        assertThatThrownBy(() -> {
            lottoNumberRangeValidator.validate(0);
        }).isInstanceOf(NotLottoNumberRange.class);
    }
}