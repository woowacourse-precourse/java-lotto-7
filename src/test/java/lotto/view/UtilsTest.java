package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.RandomNumberPicker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UtilsTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void 숫자를_오름차순으로_정렬한다(int lottoNumbersIndex) {
        List<Integer> randomNumbers = RandomNumberPicker.pickAscendingNumbers();

        List<Integer> sortedRandomNumbers = Utils.sortAscending(randomNumbers);

        assertThat(sortedRandomNumbers.get(lottoNumbersIndex))
                .isLessThan(sortedRandomNumbers.get(lottoNumbersIndex + 1));
    }

    @Test
    void 등수를_내림차순으로_정렬한다() {

    }
}
