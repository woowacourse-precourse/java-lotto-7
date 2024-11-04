package lotto;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private InputView inputView;
    void setUp() {
        inputView = new InputView();
    }

    @Test
    void testReadPurchaseAmount_InvalidInput() {
        setUp();
        provideInput("abc\n-1000\n1500\n2000");
        assertEquals(2000, inputView.readPurchaseAmount());
    }


    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
}