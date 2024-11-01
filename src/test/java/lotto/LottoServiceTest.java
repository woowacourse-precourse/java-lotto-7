package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoService;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Test
    void 구매할_로또_장수를_계산합니다() {
        LottoService lottoService = new LottoService();
        assertEquals(3, lottoService.calculateLottoCount(3000));
        assertEquals(5, lottoService.calculateLottoCount(5000));
    }

    @Test
    void 로또를_구매할_장수에_맞게_발행합니다() {
        LottoService lottoService = new LottoService();
        List<Lotto> lottos = lottoService.generateLottos(5);
        assertEquals(5, lottos.size());
        for (Lotto lotto : lottos) {
            assertEquals(6, lotto.getNumbersSize());
        }
    }
}
