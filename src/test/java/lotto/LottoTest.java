package lotto;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTest {
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
    void 로또의_개수는_6개이어야한다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(numbers);
        });
    }

    @Test
    void 로또는_중복된_수를_갖을_수_없다() {
        // given
        List<Integer> numbers = List.of(1, 2, 2, 4, 5, 6, 7);

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
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
