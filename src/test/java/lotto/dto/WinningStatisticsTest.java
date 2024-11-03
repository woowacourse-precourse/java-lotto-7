package lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @Test
    void 최종_결과_입력_검증() {
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        lotto.setRank(Rank.SIX_MATCHES);
        List<Lotto> lottoTickets = List.of(lotto);
        int amount = 10000;

        //when
        WinningStatistics winningStatistics = new WinningStatistics(lottoTickets, amount);

        //then
        assertThat(winningStatistics.toFinalString()).contains(
                "6개 일치 (2,000,000,000원) - 1개", "총 수익률은 20000000.0%입니다.");
    }
}