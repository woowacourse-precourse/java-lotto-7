package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.Test;

public class LottoRankTest {
    @Test
    void 로또_번호와_당첨_번호와_보너스_번호를_종합해_등수를_확인합니다() {
        assertEquals(LottoRank.FIRST, LottoRank.findRank(6, false));
        assertEquals(LottoRank.SECOND, LottoRank.findRank(5, true));
        assertEquals(LottoRank.THIRD, LottoRank.findRank(5, false));
        assertEquals(LottoRank.FOURTH, LottoRank.findRank(4, true));
        assertEquals(LottoRank.FOURTH, LottoRank.findRank(4, false));
        assertEquals(LottoRank.FIFTH, LottoRank.findRank(3, false));
        assertEquals(LottoRank.NONE, LottoRank.findRank(2, false));
        assertEquals(LottoRank.NONE, LottoRank.findRank(1, false));
    }
}
