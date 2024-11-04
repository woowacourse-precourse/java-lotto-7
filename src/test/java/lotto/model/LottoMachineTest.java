package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoMachine;
import lotto.model.domain.LottoTickets;
import lotto.model.generator.FixedNumberGenerator;
import lotto.model.generator.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        NumberGenerator numberGenerator = new FixedNumberGenerator(List.of(1, 2, 3, 4, 5, 6));
        lottoMachine = new LottoMachine(numberGenerator);
    }

    @Test
    @DisplayName("로또 티켓 3장이면 로또를 3장 교환해준다.")
    void testExchangeLottoSize() {
        LottoTickets lottoTickets = new LottoTickets("3000");

        assertThat(lottoMachine.generateLottos(lottoTickets))
                .hasSize(3);
    }

    @Test
    @DisplayName("로또 티켓을 주면 로또 번호를 생성해준다.")
    void testGenerateLottoNumber() {
        LottoTickets lottoTickets = new LottoTickets("1000");
        List<Lotto> lottos = lottoMachine.generateLottos(lottoTickets);

        assertThat(lottos.getFirst().getNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }
}