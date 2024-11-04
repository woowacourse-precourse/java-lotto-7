package lotto;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @DisplayName("1등 당첨 테스트")
    @Test
    void FIRST_RANK_TEST() {
        LottoRank lottoRank = LottoRank.getLottoRank(6, false);
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("2등 당첨 테스트")
    @Test
    void SECOND_RANK_TEST() {
        LottoRank lottoRank = LottoRank.getLottoRank(5, true);
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("3등 당첨 테스트")
    @Test
    void THIRD_RANK_TEST() {
        LottoRank lottoRank = LottoRank.getLottoRank(5, false);
        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("4등 당첨 테스트")
    @Test
    void FOURTH_RANK_TEST() {
        LottoRank lottoRank = LottoRank.getLottoRank(4, false);
        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("5등 당첨 테스트")
    @Test
    void FIFTH_RANK_TEST() {
        LottoRank lottoRank = LottoRank.getLottoRank(3, false);
        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("꽝 테스트")
    @Test
    void RANK_NONE_TEST() {
        LottoRank lottoRank = LottoRank.getLottoRank(1, false);
        assertThat(lottoRank).isEqualTo(LottoRank.NONE);
    }

}
