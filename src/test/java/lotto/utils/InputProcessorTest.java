package lotto.utils;

import static lotto.exception.Exception.INVALID_NUMBER;
import static lotto.exception.Exception.MAXIMUM_NUMBER_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputProcessorTest {

    @Test
    void 숫자_문자열을_올바르게_변환한다() {
        int result = InputProcessor.parseSingleInteger(" 123 ");
        assertThat(result).isEqualTo(123);
    }

    @Test
    void 숫자_문자열이_null이면_예외를_던진다() {
        assertThatThrownBy(() -> InputProcessor.parseSingleInteger(null)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER.getMessage());
    }

    @Test
    void 숫자가_아닌_문자열이면_예외를_던진다() {
        assertThatThrownBy(() -> InputProcessor.parseSingleInteger("abc")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER.getMessage());
    }

    @Test
    void 숫자_문자열이_9자_이상이면_예외를_던진다() {
        assertThatThrownBy(() -> InputProcessor.parseSingleInteger("1234567890")).isInstanceOf(
                IllegalArgumentException.class).hasMessage(MAXIMUM_NUMBER_LENGTH.getMessage());
    }

    @Test
    void 숫자_목록_문자열을_정수_리스트로_변환한다() {
        List<Integer> result = InputProcessor.parseIntegerList("1, 2,3 ,4 , 5 ");
        assertThat(result).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void 숫자_목록_문자열이_null이면_예외를_던진다() {
        assertThatThrownBy(() -> InputProcessor.parseIntegerList(null)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER.getMessage());
    }

    @Test
    void 숫자_목록에_10자_이상의_숫자가_포함되면_예외를_던진다() {
        assertThatThrownBy(() -> InputProcessor.parseIntegerList("123,1234567890"))  // 10자리 숫자 포함
                .isInstanceOf(IllegalArgumentException.class).hasMessage(MAXIMUM_NUMBER_LENGTH.getMessage());
    }
}