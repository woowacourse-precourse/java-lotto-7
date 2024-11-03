package lotto.application.statistics.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.application.prize.domain.BonusNumber;
import lotto.application.prize.domain.PrizeNumber;
import lotto.application.prize.domain.WinnerNumbers;
import lotto.application.ticket.domain.ticket.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Statistics - 통계")
class StatisticsTest {

    private Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private PrizeNumber createPrizeNumber(List<Integer> winnerNumbers, int bonusNumber) {
        return PrizeNumber.of(WinnerNumbers.of(Lotto.of(winnerNumbers)),
                BonusNumber.of(bonusNumber, Lotto.of(winnerNumbers)));
    }


    @DisplayName("로또목록과_당첨번호로_통계 생성")
    @Test
    void 로또목록과_당첨번호로_통계생성() {
        // given
        List<Lotto> lottos = List.of(
                createLotto(List.of(1, 2, 3, 4, 5, 6))
        );
        PrizeNumber prizeNumber = createPrizeNumber(
                List.of(1, 2, 3, 4, 5, 6), 7
        );

        // when
        Statistics statistics = Statistics.of(lottos, prizeNumber);

        // then
        assertThat(statistics).isNotNull();
    }

}
