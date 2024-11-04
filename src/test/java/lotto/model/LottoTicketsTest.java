package lotto.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.util.NumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {
    @Test
    @DisplayName("발행한 로또들의 당첨 결과 통계를 반환한다.")
    void testAggregateStatForGivenWinningNumbers() {
        Lotto mainNumbers = new Lotto(NumbersGenerator.MAIN_NUMBERS);
        BonusNumber bonusNumber = new BonusNumber(NumbersGenerator.BONUS_NUMBER);
        WinningNumbers winningNumbers = new WinningNumbers(mainNumbers, bonusNumber);

        Lotto fifthPrizeLotto = new Lotto(NumbersGenerator.createLottoNumbers(3, 3));
        Lotto fourthPrizeLotto = new Lotto(NumbersGenerator.createLottoNumbers(4, 2));
        LottoTickets lottoTickets = new LottoTickets(List.of(fifthPrizeLotto, fourthPrizeLotto));

        Map<Prize, Integer> result = lottoTickets.aggregateWinningResult(winningNumbers);
        assertAll(
                () -> assertThat(result.get(Prize.FIFTH)).isEqualTo(1),
                () -> assertThat(result.get(Prize.FOURTH)).isEqualTo(1),
                () -> assertThat(result.get(Prize.THIRD)).isEqualTo(0),
                () -> assertThat(result.get(Prize.SECOND)).isEqualTo(0),
                () -> assertThat(result.get(Prize.FIRST)).isEqualTo(0)
        );
    }
}
