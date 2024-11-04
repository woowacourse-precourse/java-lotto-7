package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoRankTest {
    @Test
    void 키로_맞힌_갯수_찾기(){
        assertThat(LottoRank.findRankFromKey(3)).isEqualTo(LottoRank.THREE_MATCH);
        assertThat(LottoRank.findRankFromKey(4)).isEqualTo(LottoRank.FOUR_MATCH);
        assertThat(LottoRank.findRankFromKey(5)).isEqualTo(LottoRank.FIRVE_MATCH);
        assertThat(LottoRank.findRankFromKey(6)).isEqualTo(LottoRank.FIVE_BONUS_MATCH);
        assertThat(LottoRank.findRankFromKey(7)).isEqualTo(LottoRank.SIX_MATCH);
    }

}