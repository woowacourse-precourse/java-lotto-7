package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 유효하지 않다면 예외가 발생한다.")
    @Test
    void 로또_번호가_유효하지_않다면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(null))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("로또 숫자가 범위 밖이라면 예외가 발생한다.")
    @Test
    void 로또_숫자가_범위_밖이라면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(6, 14, 26, 27, 38, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 중 하나가 유효하지 않다면 예외가 발생한다.")
    @Test
    void 로또_번호_중_하나가_유효하지_않다면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(null, 4, 2, 7, 9, 6)))
                .isInstanceOf(NullPointerException.class);
    }

}
