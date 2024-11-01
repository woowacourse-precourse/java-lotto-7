package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.model.LottoRank;
import org.junit.jupiter.api.Test;

public class LottoRankTest {
    @Test
    void 로또_번호와_당첨_번호와_보너스_번호를_종합해_등수를_확인합니다() {
        assertEquals(LottoRank.FIRST_PRIZE, LottoRank.findRank(6, false));
        assertEquals(LottoRank.SECOND_PRIZE, LottoRank.findRank(5, true));
        assertEquals(LottoRank.THIRD_PRIZE, LottoRank.findRank(5, false));
        assertEquals(LottoRank.FOURTH_PRIZE, LottoRank.findRank(4, true));
        assertEquals(LottoRank.FOURTH_PRIZE, LottoRank.findRank(4, false));
        assertEquals(LottoRank.FIFTH_PRIZE, LottoRank.findRank(3, false));
        assertEquals(LottoRank.NO_PRIZE, LottoRank.findRank(2, false));
        assertEquals(LottoRank.NO_PRIZE, LottoRank.findRank(1, false));
    }
}
