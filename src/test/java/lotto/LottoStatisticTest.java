package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticTest {
    @Test
    @DisplayName("누적 당첨을 경우에 따라 저장하고 총 수익 가중치를 계산한다.")
    void scoreBoardTest() {
        //given
        LottoStatistic lottoStatistic = new LottoStatistic();
        //when
        lottoStatistic.update(MatchType.THREE_MATCHES);
        lottoStatistic.update(MatchType.FOUR_MATCHES);
        lottoStatistic.update(MatchType.FIVE_MATCHES);
        lottoStatistic.update(MatchType.FIVE_BONUS);
        lottoStatistic.update(MatchType.SIX_MATCHES);
        int result = lottoStatistic.calculateScore();
        //then
        assertThat(result).isEqualTo(5+50+1500+2000+2000000);
    }
}
