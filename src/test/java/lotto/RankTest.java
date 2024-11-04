package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void 맞춘숫자_개수와_보너스_여부에_따른_등수반환_테스트() {
        //Given
        int numberMatch = 6;
        boolean bonus = false;

        //When
        Rank rank = Rank.getRank(numberMatch, bonus);

        //Then
        Assertions.assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    void 맞춘숫자가_5개_일_경우_보너스_여부에_따른_등수반환_테스트() {
        //Given
        int numberMatch = 5;
        boolean bonus = true;

        //When
        Rank rank = Rank.getRank(numberMatch, bonus);

        //Then
        Assertions.assertThat(rank).isEqualTo(Rank.SECOND);
    }
}