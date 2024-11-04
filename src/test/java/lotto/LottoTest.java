package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.Assertions;
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

    @Test
    void 로또를_생성한다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when, then
        Assertions.assertDoesNotThrow(() -> {
            new Lotto(numbers);
        });
    }

    @Test
    void 로또는_1에서_45_사이의_수를_가져야한다() {
        List<Integer> numbers = List.of(1000, 45, 3, 4, 5, 6, 7);

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(numbers);
        });
    }

    @Test
    void 발행한_로또와_당첨번호를_비교한다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winLottoNumbers = List.of(1, 2, 3, 4, 5, 7);

        // when
        Integer matched = lotto.compareWithWinLotto(winLottoNumbers);

        // then
        Assertions.assertEquals(matched, 5);
    }
}
