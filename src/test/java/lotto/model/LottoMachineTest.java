package lotto.model;

import lotto.util.generator.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    private static class FixedNumberGenerator implements NumberGenerator<List<Integer>> {
        @Override
        public List<Integer> generate() {
            return List.of(1, 2, 3, 4, 5, 6);
        }
    }

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine(new FixedNumberGenerator());
    }

    @Test
    @DisplayName("LottoMachine이 지정된 개수의 로또 티켓을 생성한다.")
    void 지정된_개수의_로또_티켓을_생성한다() {
        int ticketCount = 5;
        List<Lotto> lottos = lottoMachine.createLotto(ticketCount);

        assertThat(lottos).hasSize(ticketCount);
        assertThat(lottos.get(0).getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("LottoMachine이 지정된 번호로 당첨 로또 티켓을 생성한다.")
    void 지정된_번호로_당첨_로또_티켓을_생성한다() {
        List<Integer> winningNumbers = List.of(7, 8, 9, 10, 11, 12);
        Lotto winningLotto = lottoMachine.createWinningLotto(winningNumbers);

        assertThat(winningLotto.getNumbers()).containsExactly(7, 8, 9, 10, 11, 12);
    }
}
