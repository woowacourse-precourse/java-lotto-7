package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnerNumbersTest {

    @DisplayName("번호가 6개가 아니라면 예외를 반환한다.")
    @Test
    void test1() {
        assertThatThrownBy(() -> new WinnerNumbers(List.of(1, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호는 1~45 사이가 아니라면 예외를 반환한다.")
    @Test
    void test2() {
        assertThatThrownBy(() -> new WinnerNumbers(List.of(1, 2, 3, 41, 51), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호가 중복이 되면, 예외를 반환한다.")
    @Test
    void test3() {
        assertThatThrownBy(() -> new WinnerNumbers(List.of(1, 1, 3, 41, 51), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호는 1~45 사이가 아니라면 예외를 반환한다.")
    @Test
    void test4() {
        assertThatThrownBy(() -> new WinnerNumbers(List.of(1, 2, 3, 4, 5, 6), 71))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호 6개에 포함되는 값이라면 예외를 반환한다.")
    @Test
    void test5() {
        assertThatThrownBy(() -> new WinnerNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
