package lotto;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumberTest {

    @DisplayName("당첨 번호 범위가 벗어 났을때 오류가 뜨는지 테스트")
    @ParameterizedTest
    @MethodSource("providedWinningNumber")
    void WinningNumberRangeTest(List<Integer> winningNumbers, int bonusNumber) {
        Assertions.assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    static Stream<Object[]> providedWinningNumber() {
        return Stream.of(
                new Object[]{List.of(-1, 2, 3, 4, 5), 7},
                new Object[]{List.of(1, 2, 3, 4, 5, 46), 7},
                new Object[]{List.of(1, 2, 3, 4, 5, 6), 0},
                new Object[]{List.of(1, 2, 3, 4, 5, 6), 46}
        );
    }
}
