package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.model.WinningNumber;

public class WinningTest {

    @Test
    void 숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumber("일,2,3,4,5,6", "8"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정수형이_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumber("1.1,2,3,4,5,6", "1"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 양수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumber("-1,2,3,4,5,6", "8"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,60", "8"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6,7", "8"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "1"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
