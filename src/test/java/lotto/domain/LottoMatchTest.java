package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatchTest {

    @Test
    void 로또_결과_생성_성공() {
        //given
        List<LottoRank> ranks = List.of(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD);

        //when
        LottoMatch lottoMatch = new LottoMatch(ranks);

        //then
        assertThat(lottoMatch.getRanks()).isEqualTo(ranks);
    }
}