package lotto.domain.lottos.user;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.domain.lottos.Lotto;
import org.junit.jupiter.api.Test;

class BonusLottoTest {
    private BonusLotto bonusLotto;

    @Test
    void 보너스_로또_여섯자리_로또에_포함_확인() {
        bonusLotto = new BonusLotto(1);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        boolean expected = bonusLotto.isContainedMainLotto(lotto);

        assertTrue(expected);
    }

    @Test
    void 보너스_로또_여섯자리_로또에_불포함_확인() {
        bonusLotto = new BonusLotto(7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        boolean expected = bonusLotto.isContainedMainLotto(lotto);

        assertFalse(expected);
    }

}