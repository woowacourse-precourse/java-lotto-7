package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoStoreTest {
    @DisplayName("로또 구입 금액이 정상적으로 전달될 경우")
    @Test
    void 로또_구입_금액이_정상적으로_전달될_경우() {
        List<Lotto> lottos = LottoStore.purchaseLottos(9000);
        assertEquals(9, lottos.size());
    }
}
