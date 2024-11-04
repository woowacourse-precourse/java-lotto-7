package lotto;

import lotto.Utils.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    Validator validator = new Validator();

    @DisplayName("EXCEPTION_PRICE_01: 1000원 단위가 아니면 예외 발생")
    @Test
    void 가격이_1000단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validatePrice1000(45))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 구매 금액은 1000원 단위로만 입력 가능합니다.");
    }

    @DisplayName("EXCEPTION_TYPE_01: 숫자가 아닌 값이 포함되어 있으면 예외 발생")
    @Test
    void 숫자가_아닌_값이면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validateInteger("1000;"))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }

    @DisplayName("EXCEPTION_LOTTO_04: 숫자와 구분자 외의 것이 포함되면 예외 발생")
    @Test
    void 숫자와_구분자가_아닌_값이면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validateNumbersInput("1,2,3,4, 5;6"))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 로또 번호는 숫자와 구분자(,)로만 이루어져야 합니다.");
    }

    @DisplayName("EXCEPTION_NULL_01: 입력값이 비어있을 경우 예외 발생")
    @Test
    void 비어있는_입력값이면_예외_발생한다() {
        assertThatThrownBy(() -> validator.validateEmptyInput(""))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 빈 값은 입력될 수 없습니다.");
    }

    @DisplayName("EXCEPTION_LOTTO_2: 보너스 번호의 범위가 1~45여야 함")
    @Test
    void 보너스_번호가_1부터_45에_해당되지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validateBonusRange(46))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

}
