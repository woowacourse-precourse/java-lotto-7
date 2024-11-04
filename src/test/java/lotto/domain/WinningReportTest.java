package lotto.domain;

import static lotto.domain.Winning.FIFTH;
import static lotto.domain.Winning.FIRST;
import static lotto.domain.Winning.FOURTH;
import static lotto.domain.Winning.NONE;
import static lotto.domain.Winning.SECOND;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningReportTest {
    @DisplayName("Winning 상수값들을 받아 WinningReport 인스턴스를 생성한다.")
    @ParameterizedTest
    @MethodSource("provideWinningValues")
    void createWinningReportWithWinningValues(List<Winning> winnings) {
        WinningReport actual = new WinningReport(winnings);

        assertThat(actual)
                .isInstanceOf(WinningReport.class)
                .isNotNull()
                .hasNoNullFieldsOrProperties()
                .hasFieldOrProperty("winningCounts");
    }

    @DisplayName("생성된 WinningReport 인스턴스의 필드의 key로 Winning 상수값 전체가 매핑되어있다.")
    @ParameterizedTest
    @MethodSource("provideWinningValues")
    void containsOnlyAllWinningValuesAsKeysInField(List<Winning> winnings) {
        WinningReport actual = new WinningReport(winnings);
        Map<Winning, Integer> actualField = actual.getWinningCounts();

        assertThat(actualField).hasSize(Winning.values().length);
        assertThat(actualField.keySet().containsAll(List.of(Winning.values()))).isTrue();
    }

    @DisplayName("생성된 WinningReport 인스턴스의 필드에 매핑된 value값들의 총합은 전달받은 Winning 상수값들의 수와 같다.")
    @ParameterizedTest
    @MethodSource("provideWinningValues")
    void hasSumOfValuesSameWithSizeOf(List<Winning> winnings) {
        WinningReport actual = new WinningReport(winnings);
        Map<Winning, Integer> actualField = actual.getWinningCounts();

        assertThat(actualField.values().stream().reduce(0, Integer::sum)).isEqualTo(winnings.size());
    }

    private static Stream<Arguments> provideWinningValues() {
        return Stream.of(
                Arguments.of(List.of(FIRST, NONE, FOURTH, FOURTH, SECOND, FOURTH, FIFTH, NONE))
        );
    }
}