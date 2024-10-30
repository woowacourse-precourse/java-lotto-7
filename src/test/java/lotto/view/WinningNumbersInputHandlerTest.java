package lotto.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WinningNumbersInputHandlerTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "a,b,c,d,e,f", ","})
    void 당첨_번호가_정수가_아니면_예외_발생(String winningNumbers) {
        assertThatThrownBy(() -> WinningNumbersInputHandler.validateWinningNumbersAreInteger(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호들은 정수여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "-1,-2,-3,-4,-5,-6", "1000"})
    void 당첨_번호가_정수이면_예외_없음(String winningNumbers) {
        assertDoesNotThrow(() ->
                WinningNumbersInputHandler.validateWinningNumbersAreInteger(winningNumbers)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidWinningNumbers")
    void 당첨_번호가_1에서_45_사이의_값이_아니면_예외_발생(List<Integer> winningNumbers) {
        assertThatThrownBy(() -> WinningNumbersInputHandler.validateWinningNumbersRange(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당청 번호는 1에서 45 사이의 정수 값이어야 합니다.");
    }

    static Stream<List<Integer>> provideInvalidWinningNumbers() {
        return Stream.of(
                List.of(0, 1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 46)
        );
    }

    @ParameterizedTest
    @MethodSource("provideValidWinningNumbers")
    void 당첨_번호가_1에서_45_사이의_값이면_예외_없음(List<Integer> winningNumbers) {
        assertDoesNotThrow(() ->
                WinningNumbersInputHandler.validateWinningNumbersRange(winningNumbers)
        );
    }

    static Stream<List<Integer>> provideValidWinningNumbers() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 45)
        );
    }
}
