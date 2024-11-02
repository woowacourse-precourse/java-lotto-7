package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RandomNumberGeneratorTest {

    @DisplayName("주어진 범위 내의 숫자만 생성한다")
    @ParameterizedTest
    @MethodSource("provideRangeAndCount")
    public void givenRange_thenGenerateNumbersInRange(int start, int end, int count) {
        //given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        //when
        List<Integer> numbers = randomNumberGenerator.generate(start, end, count);

        //then
        assertThat(numbers).filteredOn(num -> num >= start && num <= end);
    }



    private static Stream<Arguments> provideRangeAndCount() {
        return Stream.of(
            Arguments.of(1, 45, 6),
            Arguments.of(-45, -1, 6),
            Arguments.of(-100_000, 0, 5),
            Arguments.of(0, 100_000, 5)
        );
    }
}