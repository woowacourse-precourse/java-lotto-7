package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringUtilsTest {
    @DisplayName("유효한 문자열을 정수 리스트로 변환한다.")
    @Test
    void 유효한_문자열_정수_리스트_테스트() {
        String input = "1,2,3,4,5,6";
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> result = StringUtils.parseNumbers(input);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("유효한 문자열을 정수로 변환한다.")
    @Test
    void 유효한_문자열_테스트() {
        String input = "123";
        int expected = 123;

        int result = StringUtils.parseToInt(input);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("유효하지 않은 문자열을 정수 리스트로 변환 시 예외가 발생한다.")
    @Test
    void 유효하지_않은_문자열_정수_리스트_예외_테스트() {
        String input = "1,2,three,4,5,6";

        assertThatThrownBy(() -> StringUtils.parseNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효하지 않은 문자열을 정수로 변환 시 예외가 발생한다.")
    @Test
    void 유효하지_않은_문자열_예외_테스트() {
        String input = "one23";

        assertThatThrownBy(() -> StringUtils.parseToInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}