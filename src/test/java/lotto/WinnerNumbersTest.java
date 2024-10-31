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

    @DisplayName("번호가 6개가 아니라면 예외를 반환한다.")
    @Test
    void test2() {
        assertThatThrownBy(() -> new WinnerNumbers(List.of(1, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
