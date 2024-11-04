package lotto;

import java.util.HashMap;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoMachineImplTest {
    private static final int LOTTO_NUMBER = 6;
    private static final LottoMachineImpl lottoMachine = new LottoMachineImpl();
    private static final String winningNumbers = "1,2,3,4,5,6";
    private static final String bonusNumber = "7";

    @Test
    void 발행할_개수를_입력하면_로또가_6개씩_발행_개수만큼_생성된다() {
        //given
        String money = "5000";
        //when
        List<Lotto> lottoTickets = lottoMachine.purchaseLottoTickets(money);
        //then
        Assertions.assertThat(lottoTickets.size()).isEqualTo(5);
        Assertions.assertThat(lottoTickets.get(1).getNumbers().size()).isEqualTo(LOTTO_NUMBER);
    }

    @Test
    void 자동으로_생성된_로또_결과_출력_테스트() {
        //given
        String money = "5000";
        List<Lotto> lottoTickets = lottoMachine.purchaseLottoTickets(money);
        //when
        lottoMachine.getWinningResult(lottoTickets, winningNumbers, bonusNumber);
        //then
    }

    @Test
    void 번호_3개를_맞추면_5등이_당첨된다() {
        //given
        List<Integer> lottoTicket = List.of(1, 2, 3, 40, 41, 42);
        List<Lotto> lottoTickets = List.of(new Lotto(lottoTicket));
        //when
        HashMap<LottoRank, Integer> winningResult = lottoMachine.getWinningResult(lottoTickets, winningNumbers,
                bonusNumber);
        Integer winningNumber = winningResult.get(LottoRank.RANK_5);
        //then
        Assertions.assertThat(winningNumber).isEqualTo(1);
    }

    @Test
    void 번호_4개를_맞추면_4등이_당첨된다() {
        //given
        List<Integer> lottoTicket = List.of(1, 2, 3, 4, 41, 42);
        List<Lotto> lottoTickets = List.of(new Lotto(lottoTicket));
        //when
        HashMap<LottoRank, Integer> winningResult = lottoMachine.getWinningResult(lottoTickets, winningNumbers,
                bonusNumber);
        Integer winningNumber = winningResult.get(LottoRank.RANK_4);
        //then
        Assertions.assertThat(winningNumber).isEqualTo(1);
    }

    @Test
    void 번호_5개를_맞추면_3등이_당첨된다() {
        //given
        List<Integer> lottoTicket = List.of(1, 2, 3, 4, 5, 42);
        List<Lotto> lottoTickets = List.of(new Lotto(lottoTicket));
        //when
        HashMap<LottoRank, Integer> winningResult = lottoMachine.getWinningResult(lottoTickets, winningNumbers,
                bonusNumber);
        Integer winningNumber = winningResult.get(LottoRank.RANK_3);
        //then
        Assertions.assertThat(winningNumber).isEqualTo(1);
    }

    @Test
    void 번호_5개_및_보너스_번호를_맞추면_2등이_당첨된다() {
        //given
        List<Integer> lottoTicket = List.of(1, 2, 3, 4, 5, 7);
        List<Lotto> lottoTickets = List.of(new Lotto(lottoTicket));
        //when
        HashMap<LottoRank, Integer> winningResult = lottoMachine.getWinningResult(lottoTickets, winningNumbers,
                bonusNumber);
        Integer winningNumber = winningResult.get(LottoRank.RANK_2);
        //then
        Assertions.assertThat(winningNumber).isEqualTo(1);
    }

    @Test
    void 번호_6개를_맞추면_1등이_당첨된다() {
        //given
        List<Integer> lottoTicket = List.of(1, 2, 3, 4, 5, 6);
        List<Lotto> lottoTickets = List.of(new Lotto(lottoTicket));
        //when
        HashMap<LottoRank, Integer> winningResult = lottoMachine.getWinningResult(lottoTickets, winningNumbers,
                bonusNumber);
        Integer winningNumber = winningResult.get(LottoRank.RANK_1);
        //then
        Assertions.assertThat(winningNumber).isEqualTo(1);
    }

    @Test
    void 구입_개수와_당첨_결과_데이터가_주어지면_수익률을_계산한다() {
        //given
        int purchaseNumber = 8;
        HashMap<LottoRank, Integer> winningResult = new HashMap<>();
        winningResult.put(LottoRank.RANK_1, 0);
        winningResult.put(LottoRank.RANK_2, 0);
        winningResult.put(LottoRank.RANK_3, 0);
        winningResult.put(LottoRank.RANK_4, 0);
        winningResult.put(LottoRank.RANK_5, 1);
        //then
        Double profitRate = lottoMachine.calculateProfitRate(winningResult, purchaseNumber);
        //when
        Assertions.assertThat(profitRate).isEqualTo(62.5);
    }
}