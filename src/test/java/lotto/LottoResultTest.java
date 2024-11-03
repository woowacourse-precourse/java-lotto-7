package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @Test
    void 당첨결과_계산_성공() {
        // Given
        LottoTickets tickets = new LottoTickets(1);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        tickets.getTickets().set(0, lotto);

        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");

        // When
        LottoResult result = new LottoResult(tickets, winningLotto);

        // Then
        assertThat(result.getResultMap().get(Rank.SECOND)).isEqualTo(1);
        assertThat(result.getResultMap().get(Rank.FIRST)).isEqualTo(0);
        assertThat(result.getResultMap().get(Rank.THIRD)).isEqualTo(0);
        assertThat(result.getResultMap().get(Rank.FOURTH)).isEqualTo(0);
        assertThat(result.getResultMap().get(Rank.FIFTH)).isEqualTo(0);
    }

    @Test
    void 수익률_계산_성공() {
        // Given
        LottoTickets tickets = new LottoTickets(1);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        tickets.getTickets().set(0, lotto);

        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");

        // When
        LottoResult result = new LottoResult(tickets, winningLotto);
        double profitRate = result.calculateProfitRate(1000);

        // Then
        assertThat(profitRate).isEqualTo(20000000000.00);
    }
}
