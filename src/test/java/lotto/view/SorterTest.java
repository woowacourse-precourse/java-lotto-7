package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lotto.lottoNumber.NumberPicker;
import lotto.model.lotto.lottoNumber.RandomNumberPicker;
import lotto.model.lotto.winningResult.rank.Rank;
import lotto.view.output.Sorter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SorterTest {
    @Test
    @DisplayName("[success] 6개의 등수를 등수(1, 2, .., 6)를 기준으로 내림차순 정렬한다.")
    void sortDescendingWinningRankList() {
        List<Rank> ranks = Sorter.sortDescending(
                new ArrayList<>(List.of(Rank.values())));

        for (int i = 0; i < 5; i++) {
            assertThat(ranks.get(i).getRank())
                    .isGreaterThan(ranks.get(i + 1).getRank());
        }
    }

    @Test
    @DisplayName("[success] 숫자를 오름차순 정렬한다.")
    void sortAscendingNumbers() {
        NumberPicker numberPicker = new RandomNumberPicker();
        List<Integer> randomNumbers = numberPicker.pick();

        List<Integer> sortedRandomNumbers = Sorter.sortAscending(randomNumbers);

        for (int i = 0; i < 5; i++) {
            assertThat(sortedRandomNumbers.get(i))
                    .isLessThan(sortedRandomNumbers.get(i + 1));
        }
    }
}
