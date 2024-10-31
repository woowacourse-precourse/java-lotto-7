package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {
    @DisplayName("당첨 번호 6개와 로또 번호를 비교하여 몇 개가 맞는지 센다.")
    @Test
    void test() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        int matchCount = winningNumbers.countMatch(lotto);

        assertThat(matchCount).isEqualTo(6);
    }

    @DisplayName("보너스 번호가 로또 번호에 포함되어 있는지 확인한다.")
    @Test
    void test0() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        WinningNumbers winningNumbers2 = new WinningNumbers(List.of(1, 2, 3, 4, 5, 7), 6);

        boolean hasMatchNumber = winningNumbers.hasMatchNumber(lotto);
        boolean hasMatchNumber2 = winningNumbers2.hasMatchNumber(lotto);

        assertThat(hasMatchNumber).isFalse();
        assertThat(hasMatchNumber2).isTrue();
    }

    @DisplayName("번호가 6개가 아니라면 예외를 반환한다.")
    @Test
    void test1() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호는 1~45 사이가 아니라면 예외를 반환한다.")
    @Test
    void test2() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 41, 51), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호가 중복이 되면, 예외를 반환한다.")
    @Test
    void test3() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 1, 3, 41, 51), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호는 1~45 사이가 아니라면 예외를 반환한다.")
    @Test
    void test4() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 71))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호 6개에 포함되는 값이라면 예외를 반환한다.")
    @Test
    void test5() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
