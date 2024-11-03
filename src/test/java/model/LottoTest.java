package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호가 6개가 아닙니다");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 값은 입력할 수 없습니다");
    }

    @Test
    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다")
    void 로또_번호_범위_예외() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호 범위를 벗어났습니다");
    }

    @Test
    @DisplayName("로또 번호가 정렬되어 있어야 한다")
    void 로또_번호_정렬() {
        Lotto lotto = new Lotto(List.of(45, 1, 23, 15, 35, 7));
        assertThat(lotto.getNumbers()).containsExactly(1, 7, 15, 23, 35, 45);
    }
}
