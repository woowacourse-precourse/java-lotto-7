package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.Utility.RandomNumberCreator;
import lotto.Utility.WinningNumberParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class UtilityTest {
    @Test
    void 랜덤한_6개의_수를_뽑아서_List로_반환한다() {
        List<Integer> randomNumbers = RandomNumberCreator.generateRandomNumbers();

        assertThat(randomNumbers).hasSize(6);
        assertThat(randomNumbers).allMatch(number -> 1 <= number && number <= 45);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2, 3, 4, 5, 6", "1 , 2 , 3 , 4 , 5 , 6 "})
    void 당첨_번호를_콤마로_구분한다(String inputtedNumbers) {
        List<Integer> result = WinningNumberParser.parseWinningNumbers(inputtedNumbers);
        assertThat(result).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
