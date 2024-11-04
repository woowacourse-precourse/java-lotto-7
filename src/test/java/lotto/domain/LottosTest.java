package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    @DisplayName("성공적으로 생성한 경우")
    void testValidLottos() {
        List<Lotto> lottosList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );
        Lottos lottos = new Lottos(lottosList);
        assertEquals(2, lottos.getLottos().size());
    }

}
