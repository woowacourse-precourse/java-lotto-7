package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RandomNumberGeneratorTest {

    @DisplayName("주어진 범위 내의 숫자만 생성한다.")
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

    @DisplayName("잘못된 범위를 제공할 시 형식에 맞는 예외 메시지를 던진다.")
    @ParameterizedTest
    @MethodSource("provideInvalidRangeAndCount")
    public void givenInvalidRange_thenThrowFormattedExceptionMessage(int start, int end, int count) {
        //given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        //when & then
        assertThatThrownBy(() -> randomNumberGenerator.generate(start, end, count))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageStartingWith("[ERROR]");
    }



    private static Stream<Arguments> provideRangeAndCount() {
        return Stream.of(
            Arguments.of(1, 45, 6),
            Arguments.of(-45, -1, 6),
            Arguments.of(-100_000, 0, 5),
            Arguments.of(0, 100_000, 5)
        );
    }

    private static Stream<Arguments> provideInvalidRangeAndCount() {
        return Stream.of(
            Arguments.of(45, 1, 6),
            Arguments.of(Integer.MIN_VALUE, 0, 6),
            Arguments.of(0, Integer.MAX_VALUE, 6),
            Arguments.of(Integer.MIN_VALUE, Integer.MAX_VALUE, 6),
            Arguments.of(1, 5, 100)
        );
    }
}