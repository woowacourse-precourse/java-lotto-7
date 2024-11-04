package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘으면 예외가 발생한다.")
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("생성된 Lotto가 정상적으로 숫자를 가져야 한다.")
    void 생성된_lotto가정상적으로숫자를가져야함() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when & then
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("중복된 번호로 Lotto 생성 시 예외가 발생해야 한다.")
    void 중복된번호로_lotto생성시예외발생해야함() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 3, 5, 6);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 없어야 합니다.");
    }

    @Test
    @DisplayName("유효하지 않은 숫자 범위의 Lotto 생성 시 예외가 발생해야 한다.")
    void 유효하지않은숫자범위의_lotto생성시예외발생해야함() {
        // given
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이여야 합니다.");
    }

    @Test
    @DisplayName("숫자 수가 부족한 Lotto 생성 시 예외가 발생해야 한다.")
    void 숫자수가부족한_lotto생성시예외발생해야함() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개여야 합니다.");
    }
}

