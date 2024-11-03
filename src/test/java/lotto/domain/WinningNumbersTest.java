package lotto.domain;

import lotto.common.ErrorMessage;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @ParameterizedTest
    @MethodSource("makeInstance")
    void 여섯개의_숫자를_입력하지_않으면_예외_발생(List<Integer> parsedNumbers){
        assertThatThrownBy(()->new WinningNumbers(parsedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_COUNT);
    }
    private static Stream<Arguments> makeInstance(){
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5)),
                Arguments.of(List.of(1,2,3,4,5,6,7))
        );
    }

    @ParameterizedTest
    @MethodSource("duplicatedInstance")
    void 중복된_숫자를_입력하면_예외_발생(List<Integer> parsedNumbers){
        assertThatThrownBy(() -> new WinningNumbers(parsedNumbers)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.DUPLICATED_NUMBER);
    }

    private static Stream<Arguments> duplicatedInstance(){
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5,5)),
                Arguments.of(List.of(1,2,3,5,5,5))
        );
    }

    @ParameterizedTest
    @MethodSource("outOfRangeInstance")
    void 로또범위를_벗어나는_숫자를_입력하면_예외_발생(List<Integer> parsedNumbers){
        assertThatThrownBy(() -> new WinningNumbers(parsedNumbers)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.INVALID_RANGE);
    }

    private static Stream<Arguments> outOfRangeInstance(){
        return Stream.of(
                Arguments.of(List.of(0,1,2,3,4,5)),
                Arguments.of(List.of(1,2,3,4,5,46)),
                Arguments.of(List.of(0,1,2,3,4,46))
        );
    }
}