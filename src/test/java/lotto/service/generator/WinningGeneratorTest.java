package lotto.service.generator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningGeneratorTest {

    private static final String WINNING_SEPARATOR = ",";

    @DisplayName("당첨 번호가 구분자를 포함하지 않을 경우 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "1", "12345678910", "1.2.3.4.5.6", "1;2;3;4;5;6"})
    void 당첨_번호가_구분자를_포함하지_않을_경우_예외를_발생한다(String input) {
        assertThatThrownBy(() -> WinningGenerator.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 정수가 아닐 경우 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,", "1,ㅁ,2,3,4,5", "1,2,4k2,3,4,5", ",1,2,3,4,5", "1,2,3,4,;,5"})
    void 당첨_번호가_정수가_아닐_경우_예외를_발생한다(String input) {
        assertThatThrownBy(() -> WinningGenerator.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 구분자로 구분되었을 경우 결과를 반환한다.")
    @Test
    void 당첨_번호가_구분자로_구분되었을_경우_결과를_반환한다() {
        String winning = "1,2,3,4,5,6";
        List<Integer> correctWinning = List.of(1, 2, 3, 4, 5, 6);

        WinningGenerator winningGenerator = WinningGenerator.create(winning);

        assertThat(winningGenerator.getWinning().getNumbers()).isEqualTo(correctWinning);
    }
}