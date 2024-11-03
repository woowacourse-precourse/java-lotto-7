package lotto.core.model;

import java.util.List;
import lotto.core.enums.WinningRank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @Test
    void create_LottoTicket_should_be_pass() {
        // given
        // when
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(2, 4, 6, 10, 11, 40)),
                new Lotto(List.of(10, 20, 31, 42, 44, 45))
        );
        LottoPurchaseAmount amount = LottoPurchaseAmount.lottosOf(lottos);
        LottoTicket ticket = new LottoTicket(amount, lottos);
        // then
        Assertions.assertEquals(lottos, ticket.getLottos());
        Assertions.assertEquals(3, ticket.count());
    }

    @Test
    void getWinningRanks_should_be_pass() {
        // given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // count: 3, bonus: false => RANK_5
                new Lotto(List.of(2, 4, 6, 10, 11, 45)), // count: 5, bonus: true => RANK_2
                new Lotto(List.of(10, 20, 31, 42, 44, 45)), // count: 1 bonus: true => null
                new Lotto(List.of(2, 4, 6, 10, 11, 40)), // count: 6, bonus: false => RANK_1
                new Lotto(List.of(2, 8, 11, 24, 32, 41)) // count: 2, bonus: false => null
        );
        LottoPurchaseAmount amount = LottoPurchaseAmount.lottosOf(lottos);
        LottoTicket ticket = new LottoTicket(amount, lottos);
        // when
        Lotto winningLotto = new Lotto(List.of(2, 4, 6, 10, 11, 40));
        LottoNumber bonusNumber = new LottoNumber(45);
        List<WinningRank> ranks = ticket.getWinningRanks(winningLotto, bonusNumber);
        // then
        Assertions.assertEquals(3, ranks.size());
        Assertions.assertTrue(ranks.contains(WinningRank.RANK_5));
        Assertions.assertTrue(ranks.contains(WinningRank.RANK_1));
        Assertions.assertTrue(ranks.contains(WinningRank.RANK_2));
    }
}
