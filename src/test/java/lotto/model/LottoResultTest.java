package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    @DisplayName("각 로또 결과에 따른 상금이 올바르게 반환되는지 테스트")
    void shouldReturnCorrectPrizeMoneyForEachLottoResult() {
        assertEquals(5000, LottoResult.THREE.getPrizeMoney(), "3개 일치 시 상금이 5000원이 아닙니다.");
        assertEquals(50000, LottoResult.FOUR.getPrizeMoney(), "4개 일치 시 상금이 50000원이 아닙니다.");
        assertEquals(1500000, LottoResult.FIVE.getPrizeMoney(), "5개 일치 시 상금이 1500000원이 아닙니다.");
        assertEquals(30000000, LottoResult.FIVE_BONUS.getPrizeMoney(), "5개 + 보너스 일치 시 상금이 30000000원이 아닙니다.");
        assertEquals(2000000000, LottoResult.SIX.getPrizeMoney(), "6개 일치 시 상금이 2000000000원이 아닙니다.");
    }

    @Test
    @DisplayName("당첨 개수와 보너스 여부에 따라 올바른 로또 결과가 반환되는지 테스트")
    void shouldReturnCorrectLottoResultBasedOnMatchCountAndBonus() {
        // 6개 일치 시 SIX 결과 반환
        assertEquals(LottoResult.SIX, LottoResult.getLottoResult(6, false), "6개 일치 시 결과가 SIX가 아닙니다.");

        // 5개 + 보너스 일치 시 FIVE_BONUS 결과 반환
        assertEquals(LottoResult.FIVE_BONUS, LottoResult.getLottoResult(5, true),
                "5개 + 보너스 일치 시 결과가 FIVE_BONUS가 아닙니다.");

        // 5개 일치 시 FIVE 결과 반환
        assertEquals(LottoResult.FIVE, LottoResult.getLottoResult(5, false), "5개 일치 시 결과가 FIVE가 아닙니다.");

        // 4개 일치 시 FOUR 결과 반환
        assertEquals(LottoResult.FOUR, LottoResult.getLottoResult(4, false), "4개 일치 시 결과가 FOUR가 아닙니다.");

        // 3개 일치 시 THREE 결과 반환
        assertEquals(LottoResult.THREE, LottoResult.getLottoResult(3, false), "3개 일치 시 결과가 THREE가 아닙니다.");

        // 2개 이하 일치 시 null 반환
        assertEquals(null, LottoResult.getLottoResult(2, false), "2개 이하 일치 시 결과가 null이 아닙니다.");
    }
}
