package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Test
    void 구매할_로또_장수를_계산합니다() {
        assertEquals(3, LottoService.calculateLottoCount(3000));
        assertEquals(5, LottoService.calculateLottoCount(5000));
    }

    @Test
    void 로또를_구매할_장수에_맞게_발행합니다() {
        List<Lotto> lottos = LottoService.generateLottos(5);
        assertEquals(5, lottos.size());
        for (Lotto lotto : lottos) {
            assertEquals(6, lotto.getNumbersSize());
        }
    }
}
