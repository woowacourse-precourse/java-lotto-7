package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
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

    @DisplayName("로또 번호가 오름차순으로 정렬되는지 확인한다.")
    @Test
    void 로또_번호가_오름차순으로_정렬되는지_확인한다() {
        Lotto lotto = new Lotto(List.of(42, 8, 23, 21, 43, 41));

        assertThat(lotto.getNumbers()).containsExactly(8, 21, 23, 41, 42, 43);
    }

    @DisplayName("로또 번호와 당첨 번호 간의 일치하는 숫자 개수를 반환한다.")
    @Test
    void 로또_번호와_당첨_번호_간의_일치하는_숫자_개수를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 10, 11, 12));

        int matchCount = lotto.matchCount(winningNumber);

        assertThat(matchCount).isEqualTo(3);
    }

    @DisplayName("모든 번호가 일치하지 않는 경우 0을 반환해야 한다.")
    @Test
    void 모든_번호가_일치하지_않는_경우_0을_반환해야_한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(List.of(13, 14, 15, 10, 11, 12));

        int matchCount = lotto.matchCount(winningNumber);

        assertThat(matchCount).isEqualTo(0);
    }
}
