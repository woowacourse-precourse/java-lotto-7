package lotto.model.domain;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lotto.ui.error.LottoError;
import org.junit.jupiter.api.Test;

class LottoWinningTest {

    @Test
    void 보너스번호가_당첨번호를_포함하면_예외() {
        assertThrows(IllegalArgumentException.class,
                () -> new LottoWinning(List.of(1, 2, 3, 4, 5, 6), new BonusNumber(6)),
                LottoError.DUPLICATE_BONUS_NUMBER_ERR);
    }


}