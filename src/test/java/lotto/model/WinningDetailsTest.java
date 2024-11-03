package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinningDetailsTest {
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private List<Lotto> publishedLotteries;

    @BeforeEach
    void setUp() {
        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;
        publishedLotteries = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)),
                new Lotto(Arrays.asList(1, 2, 3, 20, 21, 22)),
                new Lotto(Arrays.asList(10, 20, 30, 40, 41, 42))
        );
    }

    @Test
    @DisplayName("구매한 로또와 당첨 번호를 비교하여 랭킹 별 당첨 개수를 계산하고, 정확하게 할당한다.")
    void countWinningsOfEachRank() {
        WinningDetails winningDetails = new WinningDetails(winningNumbers, publishedLotteries, bonusNumber);
        Map<Rank, Integer> result = winningDetails.getWinningCountOfEachRank();

        assertThat(result.get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.get(Rank.SECOND)).isEqualTo(1);
        assertThat(result.get(Rank.THIRD)).isEqualTo(1);
        assertThat(result.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(result.get(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("구매한 로또와 당첨 번호를 비교하여 총 상금을 계산한다.")
    void countWinningsOfTotalPrize() {
        WinningDetails winningDetails = new WinningDetails(winningNumbers, publishedLotteries, bonusNumber);
        int totalPrize = winningDetails.getTotalPrize();

        int expectedTotalPrize = Rank.FIRST.getPrize() + Rank.SECOND.getPrize() + Rank.THIRD.getPrize() +
                Rank.FOURTH.getPrize() + Rank.FIFTH.getPrize();
        assertThat(totalPrize).isEqualTo(expectedTotalPrize);
    }
}
