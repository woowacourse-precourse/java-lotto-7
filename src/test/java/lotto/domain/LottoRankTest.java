package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import lotto.constant.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @Test
    @DisplayName("로또 랭크를 RANK_NONE을 제외하고 등수 내림차순으로 가져온다.")
    void findAllLottoRankWithOutTest() throws Exception {
        //given
        final List<LottoRank> ranks = List.of(LottoRank.RANK_5, LottoRank.RANK_4, LottoRank.RANK_3, LottoRank.RANK_2,
                LottoRank.RANK_1);
        //when
        final List<LottoRank> allLottoRankWithOutRankNone = LottoRank.findAllLottoRankWithOutRankNone();

        //then
        assertThat(allLottoRankWithOutRankNone).isEqualTo(ranks);

    }

    @Test
    @DisplayName("매치 갯수와 매치 보너스로 로또 랭크를 찾는다.")
    void findByMatchCountAndMatchBonus() throws Exception {
        //given
        final int matchCount1 = 5;
        final boolean matchBonus1 = true;
        final int matchCount2 = 6;
        final boolean matchBonus2 = false;
        final int matchCount3 = 2;
        final boolean matchBonus3 = true;

        //when

        final LottoRank byMatchCountAndMatchBonus1 = LottoRank.findByMatchCountAndMatchBonus(matchCount1, matchBonus1);
        final LottoRank byMatchCountAndMatchBonus2 = LottoRank.findByMatchCountAndMatchBonus(matchCount2, matchBonus2);
        final LottoRank byMatchCountAndMatchBonus3 = LottoRank.findByMatchCountAndMatchBonus(matchCount3, matchBonus3);

        //then

        assertAll(
                () -> assertThat(byMatchCountAndMatchBonus1).isEqualTo(LottoRank.RANK_2),
                () -> assertThat(byMatchCountAndMatchBonus2).isEqualTo(LottoRank.RANK_1),
                () -> assertThat(byMatchCountAndMatchBonus3).isEqualTo(LottoRank.RANK_NONE)
        );

    }

}
