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

    @DisplayName("로또 번호가 범위 외의 숫자를 포함하면 예외가 발생한다.")
    @Test
    void 로또_번호에_범위_외의_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45의 범위 내에 있는 경우 정상적으로 생성된다.")
    @Test
    void 로또_번호가_유효하면_정상적으로_생성된다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isNotNull();
    }

    @DisplayName("로또 번호를 조회하면 포함된 번호가 있는지 확인할 수 있다.")
    @Test
    void 로또_번호를_조회하여_번호가_포함되었는지_확인할_수_있다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.containsNumber(1)).isTrue();
        assertThat(lotto.containsNumber(7)).isFalse();
    }

    @DisplayName("로또 번호와 주어진 로또 번호 간의 일치하는 번호의 개수를 센다.")
    @Test
    void 로또_번호_일치하는_개수를_확인할_수_있다() {
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto mainNumbers = new Lotto(List.of(1, 2, 7, 8, 9, 10));

        int matchingCount = ticket.countMatchingNumbers(mainNumbers);

        assertThat(matchingCount).isEqualTo(2);
    }
}
