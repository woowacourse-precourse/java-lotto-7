package exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {
    @DisplayName("숫자가 아닌 값이 입력되면 예외가 발생한다.")
    @Test
    void 숫자가_아닌_값이_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 미만의 금액이 입력되면 예외가 발생한다.")
    @Test
    void 천원_미만의_금액이_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위가 아닌 금액이 입력되면 예외가 발생한다.")
    @Test
    void 천원_단위가_아닌_금액이_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 비어있으면 예외가 발생한다.")
    @Test
    void 구매_금액이_비어있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}