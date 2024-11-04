package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    void 로또_번호의_개수가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5))) // 5개
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개여야 합니다.");

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7))) // 7개
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5))) // 중복된 숫자 5
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 중복되지 않아야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 정상적으로 정렬되어 저장된다.")
    void 로또_번호가_정렬되어_저장된다() {
        Lotto lotto = new Lotto(List.of(5, 3, 2, 8, 1, 6));
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 5, 6, 8); // 정렬된 결과
    }

    @Test
    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    void 로또_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6))) // 0은 범위 밖
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이여야 합니다.");

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46))) // 46은 범위 밖
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이여야 합니다.");
    }
}
