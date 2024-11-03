package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lotto.RandomNumberPicker;
import lotto.model.winningResult.WinningRank;
import lotto.view.output.Sorter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SorterTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void 등수를_내림차순으로_정렬한다(int winningRanksIndex) {
        List<WinningRank> winningRanks = Sorter.sortDescending(new ArrayList<>(List.of(WinningRank.values())));

        assertThat(winningRanks.get(winningRanksIndex).getRank())
                .isGreaterThan(winningRanks.get(winningRanksIndex + 1).getRank());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void 숫자를_오름차순으로_정렬한다(int lottoNumbersIndex) {
        List<Integer> randomNumbers = RandomNumberPicker.pickAscendingNumbers();

        List<Integer> sortedRandomNumbers = Sorter.sortAscending(randomNumbers);

        assertThat(sortedRandomNumbers.get(lottoNumbersIndex))
                .isLessThan(sortedRandomNumbers.get(lottoNumbersIndex + 1));
    }
}
