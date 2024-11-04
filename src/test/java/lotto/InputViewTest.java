package lotto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private InputView inputView = new InputView();

    @Test
    void testReadPurchaseAmount_ValidInput() {
        provideInput("5000");
        assertEquals(5000, inputView.readPurchaseAmount());
    }

    @Test
    void testReadPurchaseAmount_InvalidInput() {
        provideInput("abc\n-1000\n1500\n2000");
        assertEquals(2000, inputView.readPurchaseAmount());
    }

    @Test
    void testReadWinningNumbers_ValidInput() {
        provideInput("1, 2, 3, 4, 5, 6");
        List<Integer> numbers = inputView.readWinningNumbers();
        assertEquals(List.of(1, 2, 3, 4, 5, 6), numbers);
    }

    @Test
    void testReadWinningNumbers_InvalidInput() {
        provideInput("1,2,3,4,5\n1,2,3,4,5,60\n1,2,3,4,5,5\n1,2,3,4,5,6");
        List<Integer> numbers = inputView.readWinningNumbers();
        assertEquals(List.of(1, 2, 3, 4, 5, 6), numbers);
    }

    @Test
    void testReadBonusNumber_ValidInput() {
        provideInput("7");
        int bonusNumber = inputView.readBonusNumber(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(7, bonusNumber);
    }

    @Test
    void testReadBonusNumber_InvalidInput() {
        provideInput("0\n46\n1\n8");
        int bonusNumber = inputView.readBonusNumber(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(8, bonusNumber);
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
}