package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("로또 번호가 1부터 45사이가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 48)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45사이어야 합니다.");
    }

    @DisplayName("로또 번호를 알려준다.")
    @Test
    void 로또_번호를_알려준다() {
        //given
        Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //expected
        assertThat(testLotto.getNumbers().contains(1)).isTrue();
        assertThat(testLotto.getNumbers().contains(2)).isTrue();
        assertThat(testLotto.getNumbers().contains(3)).isTrue();
        assertThat(testLotto.getNumbers().contains(4)).isTrue();
        assertThat(testLotto.getNumbers().contains(5)).isTrue();
        assertThat(testLotto.getNumbers().contains(6)).isTrue();
        assertThat(testLotto.getNumbers().contains(7)).isFalse();
    }
}
