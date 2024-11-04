package lotto.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRateDtoTest {
    @DisplayName("수익률이 소수 둘째 자리에서 반올림되어 출력되는지 테스트")
    @Test
    void 수익률_반올림_테스트() {
        double rate = 62.456;
        LottoRateDto dto = LottoRateDto.from(rate);
        assertEquals("총 수익률은 62.5%입니다.", dto.getDescription());
    }
}