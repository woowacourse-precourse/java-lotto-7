package lotto;

import lotto.domain.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RankingTest {

    @DisplayName("일치하는 숫자와 보너스번호로 랭킹을 알 수 있다.")
    @Test
    void calcRank() throws Exception{
        //given
        int collectCount = 5;
        boolean hasBonus = false;
        //when
        Ranking ranking = Ranking.calcRank(collectCount, hasBonus);
        //then
        assertThat(ranking).isEqualTo(Ranking.THIRD);
     }

     @DisplayName("3개 미만으로 일치하면 당첨되지 않는다.")
     @Test
     void unRank() throws Exception{
         //given
        int collectCount = 2;
        boolean hasBonus = false;
         //when
        Ranking ranking = Ranking.calcRank(collectCount, hasBonus);
         //then
        assertThat(ranking).isEqualTo(Ranking.UNRANKED);
      }
}