package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    @Test
    void 구매_번호와_당첨_번호를_비교해서_당첨_통계를_업데이트한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        LottoMachine lottoMachine = new LottoMachine(winningLotto, bonusNumber);

        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 10, 11, 12))
        );

        LottoResult result = lottoMachine.checkTickets(tickets);
        assertThat(result.getCount(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(result.getCount(LottoRank.THIRD)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.FIRST)).isEqualTo(1);
    }
}
