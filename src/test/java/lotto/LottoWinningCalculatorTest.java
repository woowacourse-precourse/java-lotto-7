package lotto;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoWinningCalculatorTest {
    Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);

    @Test
    void 당첨_1등_테스트() {
        // given
        List<Lotto> lottoTickets = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)) // 1등
        );
        // when
        LottoWinningResult result = LottoWinningCalculator.calculateWinningResults(new LottoTickets(lottoTickets), winningLotto);
        // then
        Assertions.assertThat(result.getResults().get(WinningPrize.FIRST)).isEqualTo(1); // 1등 티켓 수
    }

    @Test
    void 당첨_2등_테스트() {
        // given
        List<Lotto> lottoTickets = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)) // 2등
        );
        // when
        LottoWinningResult result = LottoWinningCalculator.calculateWinningResults(new LottoTickets(lottoTickets), winningLotto);
        // then
        Assertions.assertThat(result.getResults().get(WinningPrize.SECOND)).isEqualTo(1); // 2등 티켓 수
    }

    @Test
    void 당첨_3등_테스트() {
        // given
        List<Lotto> lottoTickets = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 6, 8)) // 3등
        );
        // when
        LottoWinningResult result = LottoWinningCalculator.calculateWinningResults(new LottoTickets(lottoTickets), winningLotto);
        // then
        Assertions.assertThat(result.getResults().get(WinningPrize.THIRD)).isEqualTo(1); // 3등 티켓 수
    }

    @Test
    void 당첨_4등_테스트() {
        // given
        List<Lotto> lottoTickets = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 5, 8, 9)) // 4등
        );
        // when
        LottoWinningResult result = LottoWinningCalculator.calculateWinningResults(new LottoTickets(lottoTickets), winningLotto);
        // then
        Assertions.assertThat(result.getResults().get(WinningPrize.FOURTH)).isEqualTo(1); // 4등 티켓 수
    }

    @Test
    void 당첨_5등_테스트() {
        // given
        List<Lotto> lottoTickets = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11)) // 5등
        );


        // when
        LottoWinningResult result = LottoWinningCalculator.calculateWinningResults(new LottoTickets(lottoTickets), winningLotto);
        // then
        Assertions.assertThat(result.getResults().get(WinningPrize.FIFTH)).isEqualTo(1); // 5등 티켓 수
    }

    @Test
    void 당첨_실패_테스트() {
        // given
        List<Lotto> lottoTickets = Arrays.asList(
                new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13)) // 0등
        );
        // when
        LottoWinningResult result = LottoWinningCalculator.calculateWinningResults(new LottoTickets(lottoTickets), winningLotto);
        // then
        result.getResults().keySet().forEach(prize ->
                Assertions.assertThat(result.getResults().get(prize)).isEqualTo(0)
        );
    }
}
