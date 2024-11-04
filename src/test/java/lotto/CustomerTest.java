package lotto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @DisplayName("랜덤한 숫자를 가진 로또가 만들어지는 makeLotto 메서드")
    @Test
    void makeLottoTest() {
        Lotto lotto = customer.makeLotto();
        assertEquals(6, lotto.getNumbers().size());
        assertTrue(lotto.toString().contains("["));
        assertTrue(lotto.toString().contains("]"));
    }
}
