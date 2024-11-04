package lotto.domain;

import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoResultTest {

    @CsvSource({
            "1, 1, 1, 1, 1, 3, 25394437.5",
            "0, 1, 1, 1, 1, 3, 450785.7",
            "10, 1, 1, 1, 1, 3, 117832676.5",
            "50, 1, 1, 1, 1, 3, 175493956.1",
    })
    @ParameterizedTest
    void 로또_결과를_만든다(int cnt1, int cnt2, int cnt3, int cnt4, int cnt5, int cnt6, double revenue) {
        //given
        Map<Ranking, Integer> result = Map.of(
                Ranking.FIRST, cnt1,
                Ranking.SECOND, cnt2,
                Ranking.THIRD, cnt3,
                Ranking.FOURTH, cnt4,
                Ranking.FIFTH, cnt5,
                Ranking.MISS, cnt6
        );

        //when
        LottoResult lottoResult = LottoResult.from(result);

        //then
        Assertions.assertThat(round(lottoResult.getRevenue())).isEqualTo(revenue);
    }

    private double round(double revenue) {
        return Math.round(revenue * 10) / 10.0;
    }
}