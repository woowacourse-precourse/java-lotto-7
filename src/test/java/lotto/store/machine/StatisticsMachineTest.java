package lotto.store.machine;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.store.user.Cash;
import lotto.store.user.Lotto;
import lotto.store.user.LottoTickets;
import lotto.store.winning.BonusNumber;
import lotto.store.winning.WinningLotto;
import org.junit.jupiter.api.Test;

class StatisticsMachineTest {

    private final StatisticalMachine statisticalMachine = new StatisticalMachine();

    private final LottoTickets lottoTickets = LottoTickets.from(
        List.of(
            Lotto.from(List.of(1, 2, 3, 7, 8, 9))
        )
    );

    private final WinningLotto winningLotto = WinningLotto.of(
        Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
        BonusNumber.from(7)
    );

    @Test
    void 사용자의_로또와_우승_로또를_비교하여_통계를_계산한다() {
        //given & when
        statisticalMachine.calculate(lottoTickets, winningLotto);

        //then
        String actual = statisticalMachine.toString();
        assertThat(actual).contains(
            """
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개
                """
        );
    }

    @Test
    void 사용자의_로또와_우승_로또를_비교하여_총_수익률_계산한다() {
        //given & when
        statisticalMachine.calculate(lottoTickets, winningLotto);

        //then
        double actual = statisticalMachine.getTotalProfit(Cash.from(8000));
        assertThat(actual).isEqualTo(62.5);
    }

}
