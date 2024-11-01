package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void 로또_객체_생성() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_0이_포함된다면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void 로또_번호에_음수가_포함된다면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, -2, 3, 4, 5, 6)))
                .isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void 로또_당첨_숫자의_개수를_반환한다() {
        long matchedCount = lotto.getMatchedNumbersCount(List.of(6, 5, 4, 3, 2, 1));
        assertThat(matchedCount).isEqualTo(6);
    }

    @Test
    void 로또_보너스_숫자_당첨_여부를_반환한다() {
        assertThat(lotto.checkBonusNumberMathced(6)).isTrue();
        assertThat(lotto.checkBonusNumberMathced(7)).isFalse();
    }
}
