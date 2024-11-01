package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {
    private final WinningNumber winningNumber = new WinningNumber();

    @Test
    @DisplayName("당첨 번호 입력 유효성 검사")
    void testValidate() {
        assertThatThrownBy(() -> winningNumber.validate("-1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> winningNumber.validate("1,a,3,c,5,6"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> winningNumber.validate("  1,  2,3,4, 5,6"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> winningNumber.validate("1,2 ,3,4, 5,6"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> winningNumber.validate(" 1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> winningNumber.validate("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> winningNumber.validate("1"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> winningNumber.validate("1,2"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> winningNumber.validate("1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> winningNumber.validate("1,2,3,4"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> winningNumber.validate("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> winningNumber.validate(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> winningNumber.validate("1,2,3,4,5,,6"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> winningNumber.validate("1,99,98,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> winningNumber.validate("46,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> winningNumber.validate("1,2,3,3,5,5"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> winningNumber.validate("1,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력 저장")
    void testSaveNumbers() {
        winningNumber.setNumbers("1,2,3,4,5,6");
        assertEquals(winningNumber.getNumbers(), List.of(1, 2, 3, 4, 5, 6));
    }
}
