package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    void 로또_결과_생성() {
        //given
        List<LottoRank> ranks = List.of(LottoRank.FIFTH);
        long purchaseMoney = 8_000L;

        //when
        ResultLotto resultLotto = new ResultLotto(ranks, purchaseMoney);

        //then
        assertThat(resultLotto.getProfitPercent()).isEqualTo(62.5);
    }
}
