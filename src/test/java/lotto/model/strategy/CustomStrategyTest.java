package lotto.model.strategy;

import static org.assertj.core.api.Assertions.*;

import lotto.model.lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CustomStrategyTest {

    @Test
    void 입력한_번호를_이용하여_로또가_생성됩니다() {
        CustomStrategy customStrategy = CustomStrategy.of("1,2,3,4,5,6");
        Assertions.assertThat(customStrategy.generateLotto()).isInstanceOf(Lotto.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5","1,2,3,4,5,6,7"})
    void 입력한_번호가_6개가_아닌_경우_예외가_발생합니다() {
        CustomStrategy customStrategy = CustomStrategy.of("1,2,3,4,6,6");
        assertThatThrownBy(customStrategy::generateLotto).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_번호에_중복된_숫자가_존재하는_경우_예외가_발생합니다() {
        CustomStrategy customStrategy = CustomStrategy.of("1,2,3,4,6,6");
        assertThatThrownBy(customStrategy::generateLotto).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_로또_번호가_빈_값인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> CustomStrategy.of("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_로또_번호가_숫자가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> CustomStrategy.of("1,2,3,4,오,6")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_로또_번호가_구분자를_연속으로_사용하는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> CustomStrategy.of("1,2,3,4,오,6")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_로또_번호의_마지막이_구분자로_끝나는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> CustomStrategy.of("1,2,3,4,5,6,")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_로또_번호가_구분자로_시작되는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> CustomStrategy.of(",1,2,3,4,5,6")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_로또_번호가_콤마_구분자를_사용하지_않는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> CustomStrategy.of("1:2:3:4:5:6")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_로또_번호가_콤마_구분자로_나뉘어진다() {
        CustomStrategy customStrategy = CustomStrategy.of("1,2,3,4,5,6");
        Lotto lotto = customStrategy.generateLotto();
        for (int number = 1; number < 7; number++) {
            assertThat(lotto.isContain(number)).isTrue();
        }
    }

}