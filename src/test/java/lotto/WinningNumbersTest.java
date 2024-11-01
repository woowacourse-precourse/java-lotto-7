package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    @Test
    void test1() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        int bonus = 8;

        assertThatThrownBy(() -> WinningNumbers.generate(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void test2() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
        int bonus = 8;

        assertThatThrownBy(() -> WinningNumbers.generate(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 범위 밖에 있다면 예외가 발생한다.")
    @Test
    void test3() {
        List<Integer> numbers = List.of(1, 2, 3, 999, 5, 6);
        int bonus = 8;

        assertThatThrownBy(() -> WinningNumbers.generate(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void test4() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 3;

        assertThatThrownBy(() -> WinningNumbers.generate(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 범위 밖에 있다면 예외가 발생한다.")
    @Test
    void test5() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 999;

        assertThatThrownBy(() -> WinningNumbers.generate(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

}