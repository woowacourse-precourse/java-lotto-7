package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.db.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {

    @DisplayName("buyer 의 로또와 당첨 로또를 비교하여 등수의 카운트를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:0", "3:0", "4:0", "5:2"}, delimiter = ':')
    void parseRank(int rank, int rankCnt) {
        // given
        List<Lotto> buyerLotto = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 121)));
        // when
        Lotto winningLotto =
                new Lotto(List.of(1, 2, 3, 7, 8, 9));
        int bonus = 45;
        LottoRankCounter lottoRankCounter = new LottoRankCounter(buyerLotto, winningLotto, bonus);
        // then
        assertThat(lottoRankCounter.getCnt(rank)).isEqualTo(rankCnt);
    }

    @DisplayName("5개 일치할 때 bonus 이 일치하면 2등으로 판별한다.")
    @Test
    void parseSecondRank() {
        // given
        List<Lotto> buyerLotto = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 45)));
        // when
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 45;
        LottoRankCounter lottoRankCounter = new LottoRankCounter(buyerLotto, winningLotto, bonus);
        // then
        assertThat(lottoRankCounter.getCnt(2)).isEqualTo(1);
        assertThat(lottoRankCounter.getCnt(3)).isEqualTo(0);
    }

    @DisplayName("5개 일치할 때 bonus 이 일치하지 않으면 3등으로 판별한다.")
    @Test
    void parseRank() {
        // given
        List<Lotto> buyerLotto = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 45)));
        // when
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        LottoRankCounter lottoRankCounter = new LottoRankCounter(buyerLotto, winningLotto, bonus);
        // then
        assertThat(lottoRankCounter.getCnt(2)).isEqualTo(0);
        assertThat(lottoRankCounter.getCnt(3)).isEqualTo(1);
    }

}