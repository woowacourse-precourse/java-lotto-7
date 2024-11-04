package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ExchangerTest {
    LottoMachine lottoMachine;
    Exchanger exchanger;

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 10, 11, 12, 13, 14), Prize.UNRANKED),
                Arguments.of(Arrays.asList(1, 2, 3, 10, 11, 12), Prize.FIFTH_PLACE),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 11, 12), Prize.FOURTH_PLACE),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 12), Prize.THIRD_PLACE),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), Prize.SECOND_PLACE),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Prize.FIRST_PLACE)
        );
    }

    @BeforeEach
    void setUp() {
        exchanger = new Exchanger();
        lottoMachine = new LottoMachine(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("등수에 따른 상금 수여")
    void exchangePrize(List<Integer> numbers, Prize expected) {
        Lotto lotto = new Lotto(numbers);

        Prize actual = exchanger.exchangePrize(lottoMachine, lotto);

        assertThat(actual).isEqualByComparingTo(expected);
    }
}