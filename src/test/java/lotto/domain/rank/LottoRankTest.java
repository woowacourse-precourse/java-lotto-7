package lotto.domain.rank;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class LottoRankTest {

    @ParameterizedTest
    @CsvSource({
            "6, true, FIRST",
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, true, FOURTH",
            "4, false, FOURTH",
            "3, true, FIFTH",
            "3, false, FIFTH",
    })
    void 일치한_개수와_보너스_일치_여부로_등수를_계산할_수_있다(int matchCount, boolean bonusMatched, LottoRank expectedRank) {
        // when
        Optional<LottoRank> rank = LottoRank.findBy(matchCount, bonusMatched);

        // then
        assertThat(rank).isPresent()
                .containsSame(expectedRank);
    }

    @Test
    void 당첨금_오름차순으로_정렬된_순위를_가져올_수_있다() {
        // when
        List<LottoRank> ranks = LottoRank.getRanksOrderByReward();

        // then
        assertThat(ranks)
                .containsExactly(
                        LottoRank.FIFTH,
                        LottoRank.FOURTH,
                        LottoRank.THIRD,
                        LottoRank.SECOND,
                        LottoRank.FIRST
                );
    }

}
