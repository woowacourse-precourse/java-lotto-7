package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest {

    private final BonusNumberValidator validator = new BonusNumberValidator();

    @Test
    void 보너스_숫자_검증() {
        String num = "7";
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertDoesNotThrow(() -> validator.validBonusNumber(num, winningNumber));
    }

    @Test
    void 예외_보너스_숫자_빈값() {
        String num = "";
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> validator.validBonusNumber(num, winningNumber)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 예외_보너스_숫자_범위_오류() {
        String num = "77";
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> validator.validBonusNumber(num, winningNumber)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 예외_보너스_숫자_로또_중복() {
        String num = "6";
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> validator.validBonusNumber(num, winningNumber)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 예외_보너스_숫자_형식_오류() {
        String num = "a";
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> validator.validBonusNumber(num, winningNumber)).isInstanceOf(
                IllegalArgumentException.class);
    }

}