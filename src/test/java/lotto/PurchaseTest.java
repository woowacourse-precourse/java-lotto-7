package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseTest {
    @Test
    void 로또_구입_금액이_빈값이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Purchase(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_금액이_스페이스값이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Purchase(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_금액이_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Purchase("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_금액이_양수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Purchase("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_금액이_1000단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Purchase("450"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
