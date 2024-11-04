package lotto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CustomerTest {
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();

    }

    @DisplayName("고객이 로또를 사는 buyLottos 메서드")
    @ParameterizedTest
    @ValueSource(strings = {"8000", "10000"})
    void buyLottosTest(String money) {
        assertDoesNotThrow(() -> customer.buyLottos(money));
        assertFalse(customer.getLottos().isEmpty());
    }
}
