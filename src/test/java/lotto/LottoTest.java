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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 로또_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 46, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1에서 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 일치하는지에 대한 여부를 확인한다.")
    @Test
    void 보너스_번호가_일치하는지에_대한_여부를_확인한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        boolean containsBonus = lotto.getNumbers().contains(6);
        assertThat(containsBonus).isTrue();
    }

}
