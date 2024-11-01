package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void test4() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 3;

        assertThatThrownBy(() -> new WinningNumbers(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 범위 밖에 있다면 예외가 발생한다.")
    @Test
    void test5() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 999;

        assertThatThrownBy(() -> new WinningNumbers(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

}