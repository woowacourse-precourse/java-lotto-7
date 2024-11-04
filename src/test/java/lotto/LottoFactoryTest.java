package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {

    @Test
    @DisplayName("개수 맞추기")
    void count() {
        LottoFactory factory = LottoFactory.getInstance();
        List<Lotto> lottos = factory.buyLotto(3000);
        assertEquals(3, lottos.size());
    }

}