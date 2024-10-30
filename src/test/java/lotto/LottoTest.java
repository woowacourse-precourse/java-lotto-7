package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("일치한 로또 번호 갯수를 세는 기능 테스트")
    @Test
    void 일치한_로또_번호_갯수를_세는_기능_테스트() {
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto  = new Lotto(List.of(1,2,3,4,5,10));

        int matchCount = lotto.countMatchingNumbers(winningLotto);

        Assertions.assertThat(matchCount).isEqualTo(5);

    }
}
