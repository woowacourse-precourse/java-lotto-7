package lotto;

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

    @DisplayName("로또 번호가 6개일 때 정상적으로 생성된다.")
    @Test
    void 로또_번호가_6개일_때_정상적으로_생성된다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("일치하는 숫자 개수를 업데이트할 수 있다.")
    @Test
    void 일치하는_숫자_개수를_업데이트할_수_있다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto.updateMatchCount(List.of(1, 2, 3, 7, 8, 9));
        assertThat(lotto.getMatchCount()).isEqualTo(3);
    }

    @DisplayName("보너스 번호가 포함되었는지 업데이트할 수 있다.")
    @Test
    void 보너스_번호가_포함되었는지_업데이트할_수_있다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto.updateContainsBonusNumber(6);
        assertThat(lotto.isContainsBonusNumber()).isTrue();

        lotto.updateContainsBonusNumber(7);
        assertThat(lotto.isContainsBonusNumber()).isFalse();
    }
}
