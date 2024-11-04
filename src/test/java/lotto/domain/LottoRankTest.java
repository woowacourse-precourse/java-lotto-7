package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @Test
    @DisplayName("번호 일치 개수와 보너스 번호 일치 유무로 로또 순위를 찾을 수 있다.")
    void getRank_Success() {
        // given
        int matchCount1 = 5;
        boolean hasBonusMatch1 = true;
        int matchCount2 = 6;
        boolean hasBonusMatch2 = false;

        // when
        LottoRank result1 = LottoRank.findRank(matchCount1, hasBonusMatch1);
        LottoRank result2 = LottoRank.findRank(matchCount2, hasBonusMatch2);

        // then
        assertThat(result1).isEqualTo(LottoRank.SECOND);
        assertThat(result2).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("번호 일치 개수가 3개 미만일 경우엔 순위가 NONE입니다.")
    void getNoneRank_Success() throws Exception {
        // given
        int matchCount = 2;
        boolean hasBonusMatch = false;

        // when, then
        assertThat(LottoRank.findRank(matchCount, hasBonusMatch)).isEqualTo(LottoRank.NONE);
    }
}
