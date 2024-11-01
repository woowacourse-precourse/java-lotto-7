package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputHandlerTest {
    @Test
    void 로또_구입금액이_1000단위가_아닐경우_예외_발생(){
        // Given
        int price = 5500;

        // When
        InputHandler inputHandler = new InputHandler();
        // Then
        Assertions.assertThatThrownBy(() -> inputHandler.priceInputValidator(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 1000단위만 가능합니다.");
    }

}