package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 정상_생성_테스트_로또_1개() {
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6))));

        assertNotNull(lottos);
        assertEquals(1, lottos.lottos().size());
    }

    @Test
    void 정상_생성_테스트_로또_여러_개() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        Lotto lotto3 = new Lotto(List.of(21, 22, 23, 24, 25, 26));
        Lotto lotto4 = new Lotto(List.of(31, 32, 33, 34, 35, 36));

        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4));

        assertNotNull(lottos);
        assertEquals(4, lottos.lottos().size());
    }
}