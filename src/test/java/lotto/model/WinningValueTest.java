package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningValueTest {
    @Test
    void 당첨번호와_보너스번호에_종복된_숫자있을_때_에러발생() {
        assertThatThrownBy(() -> new WinningValue(new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)), 2))
                .hasMessage("당첨 번호와 보너스 번호가 중복 됩니다.");
    }

    @Test
    void 보너스_번호가_1에서_45를_벗어날_때_에러발생() {
        assertThatThrownBy(() -> new WinningValue(new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)), 59))
                .hasMessage("번호는 1에서 45 사이여야 합니다.");
    }

    @Test
    void winningNumbers_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int num = 22;
        WinningValue winningValue = new WinningValue(new WinningNumbers(numbers), num);

        List<Integer> winningNumber = winningValue.winningNumbers();

        assertEquals(numbers, winningNumber);
    }

    @Test
    void bonusNumber_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int num = 22;
        WinningValue winningValue = new WinningValue(new WinningNumbers(numbers), num);

        int bonusNumber = winningValue.bonusNumber();

        assertEquals(num, bonusNumber);
    }
}