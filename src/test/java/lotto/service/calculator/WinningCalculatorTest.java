package lotto.service.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.factory.LottoFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningCalculatorTest {

    private List<Lotto> lottoTicket;

    @BeforeEach
    void before_each() {
        lottoTicket = List.of(LottoFactory.create(List.of(1, 2, 3, 4, 5, 6)),
                LottoFactory.create(List.of(7, 8, 9, 10, 11, 12)));
    }

    @DisplayName("로또와 당첨 번호를 비교해 일치한 개수를 반환한다.")
    @Test
    void 로또와_당첨_번호를_비교해_일치한_개수를_반환한다() {
        Lotto winning = LottoFactory.create(List.of(1, 2, 3, 4, 5, 7));
        List<Integer> correctResult = List.of(5, 1);

        List<Integer> winningResult = WinningCalculator.create(lottoTicket, winning).getWinningResult();

        assertThat(winningResult).isEqualTo(correctResult);
    }
}