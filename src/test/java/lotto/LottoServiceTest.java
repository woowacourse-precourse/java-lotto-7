package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Test
    void 로또_번호가_당첨_번호와_몇_개_일치하는지_확인합니다() {
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        int matchCount = LottoService.calculateMatchCount(userLotto, winningLotto);

        assertEquals(3, matchCount);
    }

    @Test
    void 로또_번호가_보너스_번호와_일치하는지_확인합니다() {
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;

        boolean matchBonus = LottoService.checkBonusNumberMatch(userLotto, bonusNumber);

        assertEquals(true, matchBonus);
    }
}
