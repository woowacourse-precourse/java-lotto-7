package lotto.view;

import lotto.domain.PurchasedPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("입력이 비어있으면 예외가 발생한다")
    @Test
    void inputEmptyTest() {
        assertThatThrownBy(() -> InputView.validateInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다")
    @Test
    void purchasedPriceTest() {
        assertThatThrownBy(() -> new PurchasedPrice(8900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

}
