package lotto.lotto;

import static lotto.service.InputService.getLottoPurchaseAmount;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.Lottos;
import lotto.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("구입금액으로 구매할 수 있는 로또 갯수를 출력한다.")
    public void testPurchasableQuantityBasedOnMoney() {
        // given
        User user = new User();
        Lottos lottos = new Lottos();
        user.setMoney("10000");

        // when
        lottos.makeLottos(user);
        int lottoCount = lottos.getLottosSize();

        // then
        assertEquals(lottoCount, 10);
    }
}
