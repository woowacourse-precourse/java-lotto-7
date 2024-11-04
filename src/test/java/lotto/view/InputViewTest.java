package lotto.view;


import lotto.utils.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    private void setInput(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test
    void 구입금액_유효한_입력() {
        setInput("8000\n");
        int purchaseAmount = inputView.getPurchaseAmount();
        assertEquals(8000, purchaseAmount);
    }


}
