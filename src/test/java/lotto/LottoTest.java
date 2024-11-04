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
    @DisplayName("유효한 로또 번호를 사용하면 로또가 정상적으로 생성된다.")
    @Test
    void 유효한_로또_번호로_로또가_정상적으로_생성된다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
    @DisplayName("로또 번호가 포함되어 있는지 확인한다.")
    @Test
    void 로또_번호가_포함되어_있는지_확인한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(3)).isTrue();
        assertThat(lotto.contains(7)).isFalse();
    }
    @DisplayName("일치하는 번호의 개수를 확인한다.")
    @Test
    void 일치하는_번호의_개수를_확인한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 7, 8, 9);
        int matchCount = lotto.matchCount(winningNumbers);
        assertThat(matchCount).isEqualTo(2); // 1, 2가 일치하므로 2가 되어야 함
    }
    @DisplayName("일치하는 번호가 없는 경우 0을 반환한다.")
    @Test
    void 일치하는_번호가_없는_경우_0을_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(7, 8, 9, 10);
        int matchCount = lotto.matchCount(winningNumbers);
        assertThat(matchCount).isEqualTo(0); // 일치하는 번호가 없으므로 0이 되어야 함
    }

}
