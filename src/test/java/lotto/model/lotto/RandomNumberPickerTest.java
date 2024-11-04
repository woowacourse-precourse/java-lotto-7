package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.lotto.lottoNumber.RandomNumberPicker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomNumberPickerTest {
    private final RandomNumberPicker randomNumberPicker = new RandomNumberPicker();
    private final List<Integer> randomNumbers = randomNumberPicker.pick();

    @Test
    @DisplayName("[조건 1] 6개의 정수를 반환한다.")
    void pickSixNumbers() {
        assertThat(randomNumbers.size()).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("[조건 2] 1~45 사이의 정수를 반환한다.")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void pickNumbersFromOneToFortyFive(int index) {
        assertThat(randomNumbers.get(index)).isBetween(1, 45);
    }

    @Test
    @DisplayName("[조건 3] 중복되지 않은 정수를 반환한다.")
    void pickNonDuplicatedNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int number : randomNumbers) {
            assertThat(uniqueNumbers.add(number)).isTrue();
        }
    }

}
