package lotto.util.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RandomNumberGeneratorTest {

    RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @ParameterizedTest
    @MethodSource("generateUniqueNumbersInRange")
    void 원하는_개수만큼_시작_값과_마지막_값_사이의_랜덤한_정수를_반환한다(int startInclusive, int endInclusive, int count) {
        List<Integer> numbers = randomNumberGenerator
                .generateUniqueNumbersInRange(startInclusive, endInclusive, count);
        assertThat(numbers.size()).isEqualTo(count);
        numbers.forEach(number -> {
            assertThat(number)
                    .isGreaterThan(startInclusive - 1)
                    .isLessThan(endInclusive + 1);
        });
    }

    public static Stream<Arguments> generateUniqueNumbersInRange() {
        return Stream.of(
                Arguments.of(1, 45, 6),
                Arguments.of(10, 20, 1)
        );
    }


}