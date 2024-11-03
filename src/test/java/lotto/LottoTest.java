package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
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

    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 로또_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 일치하는 번호 개수를 정확히 계산한다.")
    @Test
    void 당첨_번호와_일치하는_번호_개수를_정확히_계산한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.matchCount(List.of(1, 2, 3, 7, 8, 9))).isEqualTo(3);
    }

    @DisplayName("로또 번호에 해당 번호의 포함 여부를 확인한다.")
    @Test
    void 로또_번호에_해당_번호의_포함_여부를_확인한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.containsNumber(1)).isTrue();
        assertThat(lotto.containsNumber(7)).isFalse();
    }
}