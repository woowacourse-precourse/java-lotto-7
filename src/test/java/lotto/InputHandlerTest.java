package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class InputHandlerTest {

    @Test
    void testValidPurchaseAmount() {
        InputHandler inputHandler = new InputHandler();
        assertDoesNotThrow(() -> inputHandler.validateAmount(5000));
    }

    @Test
    void testInvalidPurchaseAmount() {
        InputHandler inputHandler = new InputHandler();
        assertThrows(IllegalArgumentException.class, () -> inputHandler.validateAmount(5500));
    }

    @Test
    void testValidWinningNumbers() {
        InputHandler inputHandler = new InputHandler();
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> inputHandler.validateWinningNumbers(validNumbers));
    }

    @Test
    void testInvalidWinningNumbers_Duplicate() {
        InputHandler inputHandler = new InputHandler();
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 2, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> inputHandler.validateWinningNumbers(duplicateNumbers));
    }

    @Test
    void testInvalidWinningNumbers_OutOfRange() {
        InputHandler inputHandler = new InputHandler();
        List<Integer> outOfRangeNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);
        assertThrows(IllegalArgumentException.class, () -> inputHandler.validateWinningNumbers(outOfRangeNumbers));
    }
}