package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberMatchTypeTest {
    @Test
    @DisplayName("일치하는 숫자 5개이고 보너스 번호 일치하면 MATCH_5_BONUS 반환 확인하기")
    public void 일치_5개_보너스_일치_테스트() {
        NumberMatchType numberMatchType = NumberMatchType.MATCH_5;
        assertThat(numberMatchType.matchBonus(true)).isEqualTo(NumberMatchType.MATCH_5_BONUS);
    }

    @Test
    @DisplayName("일치하는 숫자 4개일때 MATCH_4 반환 확인하기")
    public void 일치_4개_일치_테스트() {
        NumberMatchType numberMatchType = NumberMatchType.MATCH_4;
        assertThat(numberMatchType.matchBonus(true)).isEqualTo(NumberMatchType.MATCH_4);
    }
}