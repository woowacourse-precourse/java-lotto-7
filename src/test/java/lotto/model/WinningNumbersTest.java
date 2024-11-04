package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumbersTest {
    private static final Stream<Arguments> normalWinningNumberArguments() {
        return Stream.of(
            Arguments.arguments(List.of(1,2,3,4,5,6)),
            Arguments.arguments(List.of(3,10,23,1,13,45)),
            Arguments.arguments(List.of(45,44,43,42,41,40))
        );
    }

    @DisplayName("정상 기능 테스트")
    @ParameterizedTest
    @MethodSource("normalWinningNumberArguments")
    void 정상_기능_테스트(List<Integer> winningNumbers) {
        assertDoesNotThrow(() -> new WinningNumbers(winningNumbers));
    }

    private static final Stream<Arguments> exceptionWinningNumbersArguments() {
        return Stream.of(
            Arguments.arguments("중복되는 번호가 있을 때", List.of(1,2,3,4,5,5)),
            Arguments.arguments("1보다 작은 번호가 있을 때", List.of(0, 2,3,4,5,6)),
            Arguments.arguments("45보다 큰 번호가 있을 때", List.of(1,2,3,4,5, 46)),
            Arguments.arguments("당첨 번호가 6개보다 클 때", List.of(1,2,3,4,5,6,7)),
            Arguments.arguments("당첨 번호가 6개보다 작을 때", List.of(1,2,3,4,5)),
            Arguments.arguments("번호 중 음수가 있을 때", List.of(-1,2,3,4,5,6))
        );
    }

    @DisplayName("당첨 번호 예외 상황 테스트")
    @ParameterizedTest(name = "당첨 번호 : {0}")
    @MethodSource("exceptionWinningNumbersArguments")
    void exceptionTest(String caseName, List<Integer> exceptionNumbers) {
        assertThatThrownBy(()-> new WinningNumbers(exceptionNumbers)).isInstanceOf(IllegalArgumentException.class);
    }
}
