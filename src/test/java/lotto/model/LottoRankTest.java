package lotto.model;

import lotto.model.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoRankTest {
    @Test
    @DisplayName("일치하는 번호 갯수와 보너스 번호 일치 유무에 따른 등수 출력")
    void 일치하는_번호_갯수와_보너스_번호_일치_유무에_따른_등수_출력() {
        assertEquals(LottoRank.FIRST, LottoRank.getRank(6, false));
        assertEquals(LottoRank.SECOND, LottoRank.getRank(5, true));
        assertEquals(LottoRank.THIRD, LottoRank.getRank(5, false));
        assertEquals(LottoRank.MISS, LottoRank.getRank(0, false));
    }

    @Test
    @DisplayName("각 순위별 상금 금액 확인")
    void 각_순위별_상금_금액_확인() {
        assertEquals(2000000000, LottoRank.FIRST.getPrice());
        assertEquals(30000000, LottoRank.SECOND.getPrice());
        assertEquals(1500000, LottoRank.THIRD.getPrice());
        assertEquals(50000, LottoRank.FOUR.getPrice());
        assertEquals(5000, LottoRank.FIVE.getPrice());
        assertEquals(0, LottoRank.MISS.getPrice());
    }

    @Test
    @DisplayName("각 순위별 메시지 출력 확인")
    void 각_순위별_메시지_출력_확인() {
        assertEquals("6개 일치 (2,000,000,000원)", LottoRank.FIRST.toString());
        assertEquals("5개 일치, 보너스 볼 일치 (30,000,000원)", LottoRank.SECOND.toString());
        assertEquals("5개 일치 (1,500,000원)", LottoRank.THIRD.toString());
        assertEquals("4개 일치 (50,000원)", LottoRank.FOUR.toString());
        assertEquals("3개 일치 (5,000원)", LottoRank.FIVE.toString());
        assertEquals("낙첨", LottoRank.MISS.toString());
    }
}
