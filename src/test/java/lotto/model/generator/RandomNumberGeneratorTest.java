package lotto.model.generator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.common.Rule.MAXIMUM_RANGE_NUMBER;
import static lotto.common.Rule.MINIMUM_RANGE_NUMBER;
import static lotto.common.Rule.NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @Test
    void 범위에_맞는_숫자를_생성한다() {
        List<Integer> numbers = randomNumberGenerator.generate();
        assertThat(numbers.stream()
                .allMatch(number -> MINIMUM_RANGE_NUMBER.getNumber() <= number
                        && number <= MAXIMUM_RANGE_NUMBER.getNumber()))
                .isTrue();
    }

    @Test
    void 정해진_개수의_숫자를_출력한다() {
        List<Integer> numbers = randomNumberGenerator.generate();
        assertThat(numbers.size()).isEqualTo(NUMBER_COUNT.getNumber());
    }
}