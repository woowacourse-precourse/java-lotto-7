package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto.Lotto;
import lotto.domain.Lotto.LottoFactory;
import lotto.domain.Lotto.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottosTest {
    private Lottos lottos;
    private final int ticketCount = 5;

    @BeforeEach
    void setUp() {
        TicketPrice ticketPrice = new TicketPrice(ticketCount * 1000);
        lottos = new Lottos(ticketPrice);
    }

    @Test
    void 로또_생성_갯수_확인() {
        assertThat(lottos.getLottos().size()).isEqualTo(ticketCount);
    }

    @Test
    void 로또_불변_리스트_확인() {
        List<Lotto> lottosList = lottos.getLottos();

        assertThatThrownBy(() -> lottosList.add(LottoFactory.createAutoLotto()))
                .isInstanceOf(UnsupportedOperationException.class);
    }

}
