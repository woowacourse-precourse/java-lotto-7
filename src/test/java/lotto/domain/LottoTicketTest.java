package lotto.domain;

import lotto.constants.Ranking;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTicketTest {

    @Test
    void 로또_티켓에_있는_모든_로또의_당첨_결과를_조회한다() {
        LottoTicket lottoTicket = new LottoTicket(providerLottos());
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(List.of(1,2,3,4,5,6)), 7);

        EnumMap<Ranking, Integer> rankings = lottoTicket.checkRanking(winningLotto);

        assertThat(rankings)
                .containsEntry(Ranking.FIRST, 1)
                .containsEntry(Ranking.SECOND, 1)
                .containsEntry(Ranking.FOURTH, 1);
    }

    @Test
    void 로또_티켓의_수익률을_계산한다() {
        LottoTicket lottoTicket = new LottoTicket(List.of(Lotto.from(List.of(1,2,3,43,44,45))));
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(List.of(1,2,3,4,5,6)), 7);

        double profitRate = lottoTicket.calculateProfitRate(winningLotto);

        assertThat(profitRate).isEqualTo(500.0);
    }

    private List<Lotto> providerLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            lottos.add(Lotto.from(List.of(i + 1, i + 2, i + 3, i + 4, i + 5, i + 6)));
        }
        return lottos;
    }

}
