package lotto.model;

import lotto.util.generator.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoManagerTest {

    private LottoManager lottoManager;

    private static class FixedNumberGenerator implements NumberGenerator<List<Integer>> {
        @Override
        public List<Integer> generate() {
            return List.of(1, 2, 3, 4, 5, 6);
        }
    }

    @BeforeEach
    void setUp() {
        LottoMachine lottoMachine = new LottoMachine(new FixedNumberGenerator());
        lottoManager = new LottoManager(lottoMachine);
    }

    @Test
    @DisplayName("LottoManager가 구매한 금액에 따라 로또 티켓을 생성한다.")
    void 구매한_금액에_따라_로또_티켓을_생성한다() {
        int amount = 3000;
        List<Lotto> lottos = lottoManager.createLottoTickets(amount);

        assertThat(lottos).hasSize(3);
        assertThat(lottos.get(0).getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("LottoManager가 지정된 번호로 당첨 로또 티켓을 생성한다.")
    void 지정된_번호로_당첨_로또_티켓을_생성한다() {
        List<Integer> winningNumbers = List.of(7, 8, 9, 10, 11, 12);
        Lotto winningLotto = lottoManager.createWinningLottoTicket(winningNumbers);

        assertThat(winningLotto.getNumbers()).containsExactly(7, 8, 9, 10, 11, 12);
    }
}
