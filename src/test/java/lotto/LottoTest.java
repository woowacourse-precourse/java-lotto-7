package lotto;

import lotto.Domain.Lotto;
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

    @DisplayName("로또 번호에 1~45까지의 범위에 포함되지 않은 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_범위에_포함되지_않은_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 59, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 로또 번호를 당첨 번호와 비교하여 일치하는 수 개수 카운팅")
    @Test
    void 입력받은_로또_번호를_당첨_번호와_비교하여_일치하는_수의_개수가_맞는지_확인() {
        // given
        List<Integer> winningNumbers = List.of(1,5,3,4,11,25);

        // when
        Lotto inputLotto = new Lotto(List.of(1,38,3,6,5,24));
        int matchedCount = inputLotto.countMatchedNumber(winningNumbers);

        // then
        assertThat(matchedCount).isEqualTo(3);
    }
}
