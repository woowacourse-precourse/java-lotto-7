package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lotto.RandomNumberPicker;
import lotto.model.winningResult.WinningRank;
import lotto.view.output.Sorter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SorterTest {
    @Test
    @DisplayName("[success] 6개의 등수를 등수(1, 2, .., 6)를 기준으로 내림차순 정렬한다.")
    void sortDescendingWinningRankList() {
        List<WinningRank> winningRanks = Sorter.sortDescending(
                new ArrayList<>(List.of(WinningRank.values())));

        for (int i = 0; i < 5; i++) {
            assertThat(winningRanks.get(i).getRank())
                    .isGreaterThan(winningRanks.get(i + 1).getRank());
        }
    }

    @Test
    @DisplayName("[success] 숫자를 오름차순 정렬한다.")
    void sortAscendingNumbers() {
        List<Integer> randomNumbers = RandomNumberPicker.pickNumbers();

        List<Integer> sortedRandomNumbers = Sorter.sortAscending(randomNumbers);

        for (int i = 0; i < 5; i++) {
            assertThat(sortedRandomNumbers.get(i))
                    .isLessThan(sortedRandomNumbers.get(i + 1));
        }
    }
}
