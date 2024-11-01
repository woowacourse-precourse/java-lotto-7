package lotto;

import lotto.model.PurchaseQuantity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseQuantityTest {
    @Test
    @DisplayName("빈 문자열을 입력하면 예외가 발생한다.")
    void emptyNumber() {
        assertThatThrownBy(() -> new PurchaseQuantity(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자를 입력하면 예외가 발생한다.")
    void inputChar() {
        assertThatThrownBy(() -> new PurchaseQuantity("!"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0 이하의 수를 입력하면 예외가 발생한다.")
    void inputNotNaturalNum() {
        assertThatThrownBy(() -> new PurchaseQuantity("-2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1,000단위의 수를 입력하지 않으면 예외가 발생한다.")
    void inputNotThousand() {
        assertThatThrownBy(() -> new PurchaseQuantity("2356"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}