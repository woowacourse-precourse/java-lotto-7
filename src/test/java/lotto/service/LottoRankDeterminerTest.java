package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class LottoRankDeterminerTest {

    private LottoRankDeterminer lottoRankDeterminer;

    @BeforeEach
    void setUp() {
        lottoRankDeterminer = new LottoRankDeterminer();
    }

    @Test
    void Match_Count에_맞는_ENUM값을_MAP에_반환하면_성공한다() {
        //given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        Lotto sixMatchLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto fiveMatchWithBonus = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto fiveMatchWithoutBonus = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto fourMatchWithBonus = new Lotto(List.of(1, 2, 3, 4, 7, 20));
        Lotto fourMatch = new Lotto(List.of(1, 2, 3, 4, 10, 20));
        Lotto lowMatchLotto = new Lotto(List.of(9, 10, 11, 12, 13, 14));

        List<Lotto> lottos = List.of(sixMatchLotto, fiveMatchWithBonus, fiveMatchWithoutBonus, fourMatchWithBonus, fourMatch, lowMatchLotto);

        Map<Lotto, LottoRank> expectedResults = Map.of(
               sixMatchLotto, LottoRank.SIX_MATCH,
               fiveMatchWithBonus, LottoRank.FIVE_MATCH_BONUS,
               fiveMatchWithoutBonus, LottoRank.FIVE_MATCH,
               fourMatchWithBonus, LottoRank.FOUR_MATCH,
               fourMatch, LottoRank.FOUR_MATCH,
               lowMatchLotto, LottoRank.MISS
           );

        //when
        Map<Lotto, LottoRank> result = lottoRankDeterminer.determineLottoRanks(lottos, winningLotto, bonusNumber);
        //then
        Assertions.assertThat(result).isEqualTo(expectedResults);
    }

}
