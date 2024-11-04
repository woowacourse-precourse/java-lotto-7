package lotto.domain;

import lotto.domain.vo.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class LottoMachineTest {

    private LottoMachine lottoMachine;
    private final LottoGenerator mockLottoGenerator = count -> List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(7, 8, 9, 10, 11, 12))
    );

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine(mockLottoGenerator);
    }

    @Test
    void 구입_금액에_따라_발행할_로또_개수를_계산한다() {
        // given
        int purchaseAmount = 5000;

        // when
        int lottoCount = lottoMachine.calculateLottoCount(purchaseAmount);

        // then
        assertThat(lottoCount).isEqualTo(5);
    }

    @Test
    void 지정된_개수만큼_로또_티켓을_발행한다() {
        // given
        int count = 2;

        // when
        Lottos lottos = lottoMachine.issueLottoTickets(count);

        // then
        assertThat(lottos.getTickets()).hasSize(count);

        List<Integer> firstTicketNumbers = lottos.getTickets().get(0).getNumbers()
                .stream()
                .map(Number::lottoNumber)
                .toList();

        List<Integer> secondTicketNumbers = lottos.getTickets().get(1).getNumbers()
                .stream()
                .map(Number::lottoNumber)
                .toList();

        assertThat(firstTicketNumbers).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(secondTicketNumbers).containsExactly(7, 8, 9, 10, 11, 12);
    }
}
