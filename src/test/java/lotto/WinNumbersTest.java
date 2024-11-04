package lotto;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinNumbersTest {
    @Test
    @DisplayName("당첨 번호의 개수가 6개가 아니면 예외가 발생한다.")
    void 당첨_번호의_개수가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinNumbers(List.of(1, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }
}
