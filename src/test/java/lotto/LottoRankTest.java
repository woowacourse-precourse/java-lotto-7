package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LottoRankTest {
    @Test
    void 로또_번호와_당첨_번호와_보너스_번호를_종합해_등수를_확인합니다() {
        assertEquals(LottoRank.FIRST_PRIZE, LottoRank.findRank(6, false));
    }
}
