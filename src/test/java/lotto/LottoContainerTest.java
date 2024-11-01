package lotto;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoContainerTest {

    @DisplayName("발행된 로또 저장 테스트")
    @Test
    void 발행된_로또_저장_테스트() {
        final List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        final LottoContainer container = new LottoContainer(lottos);

        Assertions.assertEquals(container.getSize(), lottos.size());
    }

}