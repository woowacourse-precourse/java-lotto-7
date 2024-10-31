package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoMachineImplTest {
    private static final int LOTTO_NUMBER = 6;
    private static final LottoMachineImpl lottoMachine = new LottoMachineImpl();

    @Test
    void 발행할_개수를_입력하면_로또가_6개씩_발행_개수만큼_생성된다() {
        //given
        int count = 5;
        //when
        List<Lotto> lottoTickets = lottoMachine.createLottoTickets(count);
        //then
        Assertions.assertThat(lottoTickets.size()).isEqualTo(count);
        Assertions.assertThat(lottoTickets.get(1).getNumbers().size()).isEqualTo(LOTTO_NUMBER);
    }

    @Test
    void 자동으로_생성된_로또_결과_출력_테스트() {
        //given
        List<Lotto> lottoTickets = lottoMachine.createLottoTickets(5);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        //when
        lottoMachine.getWinningResult(lottoTickets, winningNumbers, bonusNumber);
        //then
    }
}