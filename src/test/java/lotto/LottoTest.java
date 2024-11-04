package lotto;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.MISS;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;

public class LottoTest {

    private final int PRICE = 1_000;
    private final List<Lotto> LOTTOS = List.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)));
    private final Customer customer = Customer.of(PRICE, LOTTOS);

    @Test
    void 천원으로_구매한_로또가_아무것도_당첨되지_않는다면_수익률은_0_퍼센트() {
        // given
        WinningLotto winningLotto = WinningLotto.of(List.of(39, 40, 41, 42, 43, 44), 45);
        // when
        EnumMap<Rank, Integer> result = customer.result(winningLotto);
        double calculate = customer.calculate(result);
        // then
        assertEquals(result.get(FIFTH), 0);
        assertEquals(result.get(FOURTH), 0);
        assertEquals(result.get(THIRD), 0);
        assertEquals(result.get(SECOND), 0);
        assertEquals(result.get(FIRST), 0);

        assertEquals(MISS.getWinningPrize() / PRICE, calculate);
    }
}
