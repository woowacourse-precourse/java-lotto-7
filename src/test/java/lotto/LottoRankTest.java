package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {
    @Test
    void 당첨_순위_결과_테스트() {
        int[] matchCounts = {0, 3, 4, 5, 5, 6};
        boolean[] isMatchBonus = {false, true, false, false, true, false};
        LottoRank[] answer = {null, LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST};

        for (int i = 0; i < matchCounts.length; i++)
            Assertions.assertThat(LottoRank.getRank(matchCounts[i], isMatchBonus[i])).isEqualTo(answer[i]);
    }
}