package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @Test
    void 중복된_숫자_있을때_에러발생() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 2, 3, 4, 5)))
                .hasMessage("중복된 번호가 존재합니다.");
    }

    @Test
    void 숫자가_6자리_이상일_때_에러발생() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 23, 3, 4, 5, 6)))
                .hasMessage("담청 번호는 6자리 입니다.");
    }

    @Test
    void 숫자가_1에서_45를_벗어날_때_에러발생() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 6, 3, 4, 55)))
                .hasMessage("번호는 1에서 45 사이여야 합니다.");
    }

    @Test
    void 숫자가_포함되어_있는지_테스트() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        assertTrue(winningNumbers.contains(2));
        assertFalse(winningNumbers.contains(29));
    }

    @Test
    void get_테스트() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(List.of(1, 2, 3, 4, 5, 6), winningNumbers.get());
    }
}