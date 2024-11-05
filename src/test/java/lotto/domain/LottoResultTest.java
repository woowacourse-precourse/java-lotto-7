package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    private Lotto winningLotto;
    private int bonusNumber;
    private LottoShop lottoShop;

    @BeforeEach
    void setUp() {
        winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;

        List<Lotto> lotteries = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10))
        );
        lottoShop = new LottoShop(new LottoTickets(lotteries));
    }

    @Test
    @DisplayName("당첨 금액 계산 테스트")
    void 당첨_금액_계산_테스트() {
        LottoResult lottoResult = new LottoResult(lottoShop, winningLotto, bonusNumber);

        long expectedPrize = Rank.FIRST_PLACE.getPrize() * 1 +
                Rank.SECOND_PLACE.getPrize() * 1 +
                Rank.THIRD_PLACE.getPrize() * 1 +
                Rank.FOURTH_PLACE.getPrize() * 1;

        assertEquals(expectedPrize, lottoResult.calculateWinningPrize());
    }

}
