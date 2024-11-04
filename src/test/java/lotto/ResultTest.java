package lotto;

import lotto.domain.Ranking;
import lotto.domain.Result;
import lotto.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ResultTest {

    @DisplayName("당첨결과로 총 수익,수익률,랭킹 수를 알 수 있다.")
    @Test
    void result() throws Exception{
        //given
        List<Ranking> ranks = List.of(Ranking.FIRST, Ranking.SECOND, Ranking.UNRANKED);
        //when
        Result result = new Result(ranks);
        long total = Ranking.FIRST.getPrice() + Ranking.SECOND.getPrice() + Ranking.UNRANKED.getPrice();
        double rate = (double) total / (long) (ranks.size() * 1000) * 100;

        //then
        assertThat(result.getProfitRate())
                .isEqualTo(rate);
        assertThat(result.getTotalPrice())
                .isEqualTo(total);
     }

}