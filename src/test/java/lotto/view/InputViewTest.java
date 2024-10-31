package lotto.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }


    @Test
    void 구입금액을_정상적으로_입력받는지_확인() {
        // Arrange
        String simulatedInput = "1000";

        // Act
        String purchaseAmount = inputView.requestPurchaseAmount(simulatedInput);

        // Assert
        assertEquals("1000", purchaseAmount);
    }
}