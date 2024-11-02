package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아닌 경우 예외 발생")
    @Test
    void isPurchasePriceByThousand() {
        assertThatThrownBy(() -> inputView.validatePurchasePriceByThousand(8090))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 숫자가 아닌 경우 예외 발생")
    @Test
    void isPurchasePriceNumber() {
        assertThatThrownBy(() -> inputView.validatePurchasePriceIsNumber("5000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 마지막에 쉼표를 입력한 경우 예외 발생")
    @Test
    void isLastCharacterComma() {
        assertThatThrownBy(() -> inputView.validateLastCharComma("4,15,30,35,41,43,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 쉼표가 아닌 다른 구분자를 입력한 경우 예외 발생")
    @Test
    void isNonCommaDelimiter() {
        assertThatThrownBy(() -> inputView.validateNonCommaDelimiter("4-15-30-35-41-43"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
