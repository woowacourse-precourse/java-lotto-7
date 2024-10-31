package lotto.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import net.bytebuddy.build.ToStringPlugin.Enhance;
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

    @Test
    void 당첨번호를_정상적으로_입력받는지_확인() {
        // Arrange
        String simulatedInput = "1,2,3,4,5,6";

        // Act
        String winningNumbers = inputView.requestWinningNumbers(simulatedInput);

        // Assert
        assertEquals("1,2,3,4,5,6", winningNumbers);
    }

    @Test
    void 보너스번호를_정상적으로_입력받는지_확인() {
        // Arrange
        String simulatedInput = "7";

        // Act
        int bonusNumber = inputView.requestBonusNumber(simulatedInput);

        // Assert
        assertEquals(7, bonusNumber);
    }
}