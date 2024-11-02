package lotto.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest {

    @BeforeEach
    void setUp() {
        InputStream standardIn = System.in;
    }

    private void setInput() {
        System.setIn(new ByteArrayInputStream("8000\n".getBytes()));
    }

    @DisplayName("구입금액 입력 확인")
    @Test
    void 구입금액_입력_테스트() {
        setInput();
        int amount = InputView.inputPurchaseAmount();
        assertEquals(8000, amount);
    }
}
