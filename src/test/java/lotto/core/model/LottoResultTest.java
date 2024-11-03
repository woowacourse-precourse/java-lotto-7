package lotto.core.model;

import java.math.BigDecimal;
import java.util.List;
import lotto.core.enums.WinningRank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void getRateOfReturn_should_be_pass() {
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
        Lotto winningLotto = new Lotto(List.of(2, 4, 6, 10, 11, 40));
        LottoNumber bonusNumber = new LottoNumber(45);
        List<WinningRank> ranks = ticket.getWinningRanks(winningLotto, bonusNumber);
        // when
        LottoResult result = new LottoResult(ticket, ranks);
        // then
        // purchase amount: 5000
        // winning amount: 2_030_005_000
        BigDecimal expect = BigDecimal.valueOf(406_001_000L, 1); // 40600100.0
        Assertions.assertEquals(expect, result.getRateOfReturn());
    }

    @Test
    void getRateOfReturn_when_round_should_be_pass() {
        // given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // count: 3, bonus: false => RANK_5
                new Lotto(List.of(2, 7, 9, 14, 42, 43)), // count: 1, bonus: true => null
                new Lotto(List.of(10, 20, 31, 42, 44, 45)), // count: 1 bonus: true => null
                new Lotto(List.of(3, 5, 7, 13, 25, 31)), // count: 0, bonus: false => null
                new Lotto(List.of(2, 8, 11, 24, 32, 41)), // count: 2, bonus: false => nul
                new Lotto(List.of(10, 20, 31, 42, 44, 45)), // count: 1 bonus: true => null
                new Lotto(List.of(3, 5, 7, 13, 25, 31)), // count: 0, bonus: false => null
                new Lotto(List.of(2, 8, 11, 24, 32, 41)), // count: 2, bonus: false => null
                new Lotto(List.of(10, 20, 31, 42, 44, 45)), // count: 1 bonus: true => null
                new Lotto(List.of(3, 5, 7, 13, 25, 31)), // count: 0, bonus: false => null
                new Lotto(List.of(2, 8, 11, 24, 32, 41)) // count: 2, bonus: false => nulll
        );
        LottoPurchaseAmount amount = LottoPurchaseAmount.lottosOf(lottos);
        LottoTicket ticket = new LottoTicket(amount, lottos);
        Lotto winningLotto = new Lotto(List.of(2, 4, 6, 10, 11, 40));
        LottoNumber bonusNumber = new LottoNumber(45);
        List<WinningRank> ranks = ticket.getWinningRanks(winningLotto, bonusNumber);
        // when
        LottoResult result = new LottoResult(ticket, ranks);
        // then
        // purchase amount: 11000
        // winning amount: 5000
        BigDecimal expect = BigDecimal.valueOf(455, 1); // 45.5
        Assertions.assertEquals(expect, result.getRateOfReturn());
    }
}
