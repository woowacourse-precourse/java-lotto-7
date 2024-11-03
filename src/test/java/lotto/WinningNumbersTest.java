package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersTest {

    @Test
    void 당첨번호와_보너스번호를_생성한다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        Integer bonus = 7;

        // when
        WinningNumbers winningNumbers = new WinningNumbers(lotto, bonus);

        // then
        Assertions.assertThat(winningNumbers).isInstanceOf(WinningNumbers.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5})
    void 당첨번호와_보너스번호가_같으면_예외를_반환한다(int bonus) {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(lotto, bonus);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 47})
    void 보너스번호가_범위를_벗어나면_예외를_반환한다(int bonus) {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(lotto, bonus);
        });
    }
}
