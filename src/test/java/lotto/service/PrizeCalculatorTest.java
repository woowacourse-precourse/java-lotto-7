package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrizeCalculatorTest {
    private PrizeCalculator prizeCalculator;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        prizeCalculator = new PrizeCalculator();
        winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
    }

    @Test
    void 총상금계산_유효한로또티켓목록_정확한총상금반환() {
        //given
        Lotto firstRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto secondRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto thirdRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        Lotto noRankLotto = new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15));

        Iterable<Lotto> lottoTickets = Arrays.asList(firstRankLotto, secondRankLotto, thirdRankLotto, noRankLotto);

        //when
        int totalPrize = prizeCalculator.calculateTotalPrize(lottoTickets, winningLotto);

        //then
        int expectedTotalPrize = LottoRank.FIRST.getPrizeAmount() +
                LottoRank.SECOND.getPrizeAmount() +
                LottoRank.THIRD.getPrizeAmount();
        assertEquals(expectedTotalPrize, totalPrize);
    }

    @Test
    void 총상금계산_모두꽝인로또티켓목록_총상금0() {
        //given
        Lotto noRankLotto1 = new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15));
        Lotto noRankLotto2 = new Lotto(Arrays.asList(20, 21, 22, 23, 24, 25));
        Iterable<Lotto> lottoTickets = Arrays.asList(noRankLotto1, noRankLotto2);

        //when
        int totalPrize = prizeCalculator.calculateTotalPrize(lottoTickets, winningLotto);

        //then
        assertEquals(0, totalPrize);
    }
}