package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    private Lotto lotto;
    private Lotto otherLotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        otherLotto = new Lotto(List.of(4, 5, 6, 7, 8, 9));
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
    void 두_로또_간의_일치하는_번호_개수를_계산한다() {
        // when
        int matchingCount = lotto.countMatchingNumbers(otherLotto);

        // then
        assertThat(matchingCount).isEqualTo(3);
    }

    @Test
    void 로또_번호가_특정_숫자를_포함하면_true를_반환한다() {
        // when
        boolean contains = lotto.containsNumber(3);

        // then
        assertThat(contains).isTrue();
    }

    @Test
    void 로또_번호가_특정_숫자를_포함하지_않으면_false를_반환한다() {
        // when
        boolean contains = lotto.containsNumber(10);

        // then
        assertThat(contains).isFalse();
    }
}
