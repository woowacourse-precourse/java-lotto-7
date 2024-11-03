package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPrizeTest {

    @DisplayName("LottoRank로부터 LottoPrize를 계산해 반환한다.")
    @Test
    void calculateLottoPrize() {
        LottoTickets lottoTickets = new LottoTickets(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),   // FIRST
                new Lotto(List.of(1, 2, 3, 4, 5, 10)),  // SECOND (bonusNumber==10)
                new Lotto(List.of(1, 2, 3, 4, 5, 45)),  // THIRD
                new Lotto(List.of(1, 2, 3, 4, 7, 45)),  // FOURTH
                new Lotto(List.of(1, 2, 3, 7, 8, 45)),  // FIFTH
                new Lotto(List.of(1, 2, 3, 7, 9, 45))   // FIFTH
        ));

        Lotto winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 10;
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers.getNumbers(), bonusNumber);

        LottoRank lottoRank = new LottoRank(lottoTickets, winningLotto);
        LottoPrize lottoPrize = new LottoPrize(lottoRank);

        int expectedTotalPrize = Rank.FIRST.getReward() * 1 +
                Rank.SECOND.getReward() * 1 +
                Rank.THIRD.getReward() * 1 +
                Rank.FOURTH.getReward() * 1 +
                Rank.FIFTH.getReward() * 2;

        assertEquals(expectedTotalPrize, lottoPrize.getLottoPrize());
    }
}
