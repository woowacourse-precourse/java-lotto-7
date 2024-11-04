package lotto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @Test
    void 당첨번호와_보너스번호를_생성한다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        Bonus bonus = new Bonus(7);

        // when
        WinningNumbers winningNumbers = new WinningNumbers(lotto, bonus);

        // then
        Assertions.assertThat(winningNumbers).isInstanceOf(WinningNumbers.class);
    }

    @Test
    void 보너스번호와_당첨번호가_같으면_예외를_반환한다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        Bonus bonus = new Bonus(6);

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(lotto, bonus);
        });
    }
}
