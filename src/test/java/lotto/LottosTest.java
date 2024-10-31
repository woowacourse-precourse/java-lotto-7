package lotto;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또 6개를 산다")
    @Test
    void take6Lottos() {
        Lottos lottos = Lottos.from(6L);
        assertEquals(6, lottos.getSize());
    }
}
