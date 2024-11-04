package lotto.validate;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    Validator validator = new Validator();
    BonusNumberFormula bonusNumberFormula = new BonusNumberFormula();

    @Test
    void 구입_금액이_비어_있으면_예외() {
        assertThatThrownBy(() -> validator.payment(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 값을 입력해 주세요.");
    }

    @Test
    void 구입_금액이_정수가_아니면_예외() {
        assertThatThrownBy(() -> validator.payment("payment"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정수를 입력해 주세요.");
    }

    @Test
    void 구입_금액이_양수가_아니면_예외() {
        assertThatThrownBy(() -> validator.payment("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양수를 입력해 주세요.");
    }

    @Test
    void 구입_금액이_1000원으로_나누어_떨어지지_않으면_예외() {
        assertThatThrownBy(() -> validator.payment("1001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1,000 단위의 입력만 가능합니다.");
    }

    @Test
    void 당첨_번호에_다른_문자가_있으면_예외() {
        assertThatThrownBy(() -> validator.winningNumber("1,2,3,4,5,6a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자와 쉼표(,)만 입력 가능합니다.");
    }

    @Test
    void 당첨_번호가_잘못된_형식이면_예외() {
        assertThatThrownBy(() -> validator.winningNumber("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바르지 않은 형식입니다.");
    }

    @Test
    void 보너스_번호가_정수가_아니면_예외() {
        assertThatThrownBy(() -> validator.bonusNumber("bonusNumber"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정수를 입력해 주세요.");
    }

    @Test
    void 보너스_번호가_잘못된_범위면_예외() {
        assertThatThrownBy(() -> validator.bonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 사이의 값이어야 합니다.");
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복이면_예외() {
        String winningNumber = "1,2,3,4,5,6";

        assertThatThrownBy(() -> bonusNumberFormula.isDuplicate("6", winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 값은 불가능합니다.");
    }

}