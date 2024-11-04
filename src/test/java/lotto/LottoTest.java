package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.model.Lotto;
import lotto.numbergenerator.CorrectNumberGenerator;
import lotto.numbergenerator.WrongRangeNumberGenerator;
import lotto.numbergenerator.WrongSizeNumberGenerator;

class LottoTest {

    @Test
    void 로또_정상_동작_테스트() {
        assertSimpleTest(() -> {
            Lotto lotto = new Lotto(new CorrectNumberGenerator().generateNumber());
            assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        });
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(new WrongSizeNumberGenerator().generateNumber()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(new WrongSizeNumberGenerator().generateNumber()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_범위를_벗어난_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(new WrongRangeNumberGenerator().generateNumber()))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
