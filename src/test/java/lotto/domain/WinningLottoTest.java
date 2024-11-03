package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void 보너스_번호가_로또번호와_중복되는_경우() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = new BonusBall(6);

        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(lotto, bonusBall));
    }

}