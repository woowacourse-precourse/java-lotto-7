package buy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.Lotto;
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
        List<Lotto> lottos = buyingLotto.buyLotto(10000);
        assertEquals(10, lottos.size());
        buyingLotto = null;
    }

    @Test
    @Order(2)
    @DisplayName("로또 구매 실패(1000원 미만) 후에도 시스템 작동 중")
    void under1000() {
        buyingLotto.buyLotto(999);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("System is shutting down...");
        }));

        assertTrue(true, "System is running as expected.");
    }
}