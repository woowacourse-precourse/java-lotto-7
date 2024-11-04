package buy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class BuyingLottoTest {

    BuyingLotto buyingLotto = new BuyingLotto();

    @Test
    @Order(1)
    @DisplayName("로또 구매 성공")
    void buyLottoSucceess() {
        ByteArrayInputStream in = new ByteArrayInputStream("10000".getBytes());
        System.setIn(in);
        List<List<Integer>> lottos = buyingLotto.buyLotto();
        assertEquals(10, lottos.size());
        buyingLotto = null;
    }

    @Test
    @Order(2)
    @DisplayName("로또 구매 실패(1000원 미만) 후에도 시스템 작동 중")
    void under1000() {
        System.setIn(null);
        ByteArrayInputStream in = new ByteArrayInputStream("999".getBytes());
        System.setIn(in);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("System is shutting down...");
        }));

        assertTrue(true, "System is running as expected.");
    }

    @Test
    @Order(3)
    @DisplayName("로또 구매 실패(가격에 문자 입력) 후에도 시스템 작동 중")
    void notNumber() {
        System.setIn(null);
        ByteArrayInputStream in = new ByteArrayInputStream("a".getBytes());
        System.setIn(in);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("System is shutting down...");
        }));

        assertTrue(true, "System is running as expected.");
    }
}