package lotto.model.domain;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoWinningNumbersTest {

    @Test
    void 보너스_번호가_1부터45_사이의_범위를_벗어나면_예외() {

        assertThrows(IllegalArgumentException.class,
                () -> new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 66), 7),
                LottoError.LOTTO_NUM_OUT_OF_RANGE_ERR);
    }

    @Test
    void 보너스번호가_당첨번호를_포함하면_예외() {
        assertThrows(IllegalArgumentException.class,
                () -> new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6),
                LottoError.DUPLICATE_BONUS_NUMBER_ERR);
    }

}