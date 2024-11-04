package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class ConvertInputTest {
    @Test
    void 구입금액에_문자가_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> ConvertInput.makeMoneyToInt("우테코프리코스"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @CsvSource({"1000,1000", "3000,3000", "450,450"})
    @ParameterizedTest
    void 구입금액에_수를_입력하면_예외가_발생하지_않는다(String input, int expected) {
        assertThat(ConvertInput.makeMoneyToInt(input)).isEqualTo(expected);
    }

    @Test
    void 로또_번호에_문자가_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> ConvertInput.makeWinningNumberToList("우테코,프리코스,3주차,화이팅,7,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("generateLottoData")
    void 입력한_문자열이_수로만_구성되면_예외가_발생하지_않는다(String input, List<Integer> expected) {
        assertThat(ConvertInput.makeWinningNumberToList(input)).isEqualTo(expected);
    }

    static Stream<Arguments> generateLottoData() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6,7", List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of("1,45,2,9,0", List.of(1, 45, 2, 9, 0)),
                Arguments.of("1,2,3,4,5,6", List.of(1, 2, 3, 4, 5, 6))
        );
    }

    @Test
    void 보너스_번호에_문자가_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> ConvertInput.makeBonusNumberToInt("로또당첨기원"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @CsvSource({"1,1", "10,10", "46,46"})
    @ParameterizedTest
    void 입력한_보너스_번호가_숫자일_경우에는_예외가_발생하지_않는다(String input, int expected) {
        assertThat(ConvertInput.makeBonusNumberToInt(input)).isEqualTo(expected);
    }
}
