package lotto;

import static lotto.util.StringProcessor.integerConverter;
import static lotto.util.StringProcessor.integerListConverter;
import static lotto.util.StringProcessor.removeCommas;
import static lotto.util.StringProcessor.splitInputString;
import static lotto.util.StringProcessor.validateInput;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringProcessorTest {
    @Test
    @DisplayName("콤마_제거를_확인하는_테스트")
    void 콤마_제거를_확인하는_테스트() {
        assertThat(removeCommas("1,000,000"))
                .contains("1000000");
    }

    @ParameterizedTest
    @DisplayName("Null값_빈_값_입력_예외테스트")
    @MethodSource("inputs")
    void Null값_빈값_입력_예외테스트(String input) {
        assertThatThrownBy(() -> validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    static Stream<String> inputs() {
        return Stream.of(null, "");
    }

    @ParameterizedTest
    @DisplayName("문자열_정수_변환_예외테스트")
    @ValueSource(strings = {"0", "2200000000", "test", "1000k"})
    void 문자열_정수_변환_예외테스트(String input) {
        assertThatThrownBy(() -> integerConverter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("문자열_정수_변환_테스트")
    void 문자열_정수_변환_테스트() {
        assertThat(integerConverter("200000"))
                .isEqualTo(200000);
    }

    @Test
    @DisplayName("문자열 쉼표 구분 테스트")
    void 문자열_쉼표_구분_테스트() {
        assertThat(splitInputString("1,2,3")).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("문자열 한 개 쉼표 구분 테스트")
    void 문자열_한_개_쉼표_구분_테스트() {
        assertThat(splitInputString("1")).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 배열 정수형 List 변환 테스트")
    void 문자열_배열_정수형_List_변환_테스트() {
        String[] values = {"1", "2", "3"};
        assertThat(integerListConverter(values)).isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3)));
    }
}
