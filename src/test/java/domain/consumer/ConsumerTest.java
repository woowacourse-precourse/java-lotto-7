package domain.consumer;

import static org.junit.jupiter.api.Assertions.*;

import io.Input;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsumerTest {
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUpInput() {
        String input = "5000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @AfterEach
    void restoreInput() {
        System.setIn(originalIn);
    }

    @DisplayName("금액에 맞는 로또 수량 테스트")
    @Test
    void purchaseLottoByMoneyTest() {
        Consumer consumer = new Consumer();
        int quantity = consumer.getQuantityPurchaseLottoBy(Input.getMoneyFoPurchaseLotto());
        assertEquals(quantity, 5);
    }
}