package lotto;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class LottoInspectorTest {
    @Test
    void 로또_당첨_결과_정상동작() {
        Lotto winnerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoBonus lottoBonus = new LottoBonus(winnerLotto, 7);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 6; i < 10; i++) {
            lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, i)));
        }

        Map<Place, Integer> map = LottoInspector.checkLottos(lottoBonus, lottos);

        assertFalse(map.isEmpty());
    }
}