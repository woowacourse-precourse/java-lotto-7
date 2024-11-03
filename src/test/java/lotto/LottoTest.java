package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 번호와 일치하는 개수에 따라 적절한 등수가 반환되는지 테스트")
    @Test
    void 당첨_등수_확인_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.getRank(List.of(1, 2, 3, 4, 5, 6), 7)).isEqualTo(Rank.FIRST);
        assertThat(lotto.getRank(List.of(1, 2, 3, 4, 5, 7), 6)).isEqualTo(Rank.SECOND);
        assertThat(lotto.getRank(List.of(1, 2, 3, 4, 5, 8), 7)).isEqualTo(Rank.THIRD);
        assertThat(lotto.getRank(List.of(1, 2, 3, 4, 10, 11), 7)).isEqualTo(Rank.FOURTH);
        assertThat(lotto.getRank(List.of(1, 2, 3, 9, 10, 11), 7)).isEqualTo(Rank.FIFTH);
        assertThat(lotto.getRank(List.of(10, 20, 30, 40, 41, 42), 7)).isEqualTo(Rank.NONE);
    }
}
