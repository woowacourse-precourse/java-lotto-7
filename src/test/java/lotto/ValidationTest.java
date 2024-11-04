package lotto;

import lotto.validation.InputValid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {
    @Test
    void 입력이_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValid.checkInt("1000d"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_1에서_45사이의_수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValid.checkEachNum("47"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액이_0보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValid.checkMoney("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액이_1000으로_나누어떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValid.checkMoney("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_당첨번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValid.checkBonus("1", new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
