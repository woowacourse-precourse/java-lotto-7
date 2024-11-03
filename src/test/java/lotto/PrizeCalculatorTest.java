package lotto;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningNumbers;
import lotto.service.PrizeCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeCalculatorTest {

    private final PrizeCalculator prizeCalculator = new PrizeCalculator();

    @DisplayName("calculateRank 메서드 - 5개 번호와 보너스 번호가 일치하여 2등 당첨")
    @Test
    void calculateRank_returnsSecondRank() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        Rank rank = prizeCalculator.calculateRank(lotto, winningNumbers);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
    @DisplayName("calculateRank 메서드 - 5개 번호와 보너스 번호가 불일치하여 3등 당첨")
    @Test
    void calculateRank_returnsThirdRank() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 8);

        Rank rank = prizeCalculator.calculateRank(lotto, winningNumbers);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }
    @DisplayName("calculateMatchCount 메서드 - 로또 번호와 당첨 번호 간 일치 개수 계산")
    @Test
    void calculateMatchCount_returnsCorrectMatchCount() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        int matchCount = prizeCalculator.calculateMatchCount(lotto, winningNumbers);
        assertThat(matchCount).isEqualTo(3);
    }

    @DisplayName("calculateTotalPrize 메서드 - 여러 로또의 총 상금 계산")
    @Test
    void calculateTotalPrize_returnsCorrectTotalPrize() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),  // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8))   // 3등
        );
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        int totalPrize = prizeCalculator.calculateTotalPrize(lottos, winningNumbers);
        int expectedPrize = Rank.FIRST.getPrize() + Rank.SECOND.getPrize() + Rank.THIRD.getPrize();

        assertThat(totalPrize).isEqualTo(expectedPrize);
    }
}

