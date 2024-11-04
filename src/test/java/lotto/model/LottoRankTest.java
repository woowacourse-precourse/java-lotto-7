package lotto.model;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class LottoRankTest {
    @Test
    void 로또가_몇_등인_지_알맞게_출력되는_지_확인(){
        //Given
        SoftAssertions softly = new SoftAssertions();

        //When
        LottoRank rank1 = LottoRank.getRank(3, true);
        LottoRank rank2 = LottoRank.getRank(5, true);
        LottoRank rank3 = LottoRank.getRank(5, false);
        LottoRank rank4 = LottoRank.getRank(6, false);

        //Then
        softly.assertThat(rank1).isEqualTo(LottoRank.NONE);
        softly.assertThat(rank2).isEqualTo(LottoRank.SECOND);
        softly.assertThat(rank3).isEqualTo(LottoRank.THIRD);
        softly.assertThat(rank4).isEqualTo(LottoRank.FIRST);
        softly.assertAll();
    }
}
