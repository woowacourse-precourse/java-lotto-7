package lotto.study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

    @Test
    void 입력을_분리할_수_있다() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("1", "2");
    }

    @Test
    void 숫자_한개_입력을_분리할_수_있다() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    void 괄호를_포함한_문자열에서_괄호제거() {
        String input = "(1,2)";
        String result = input.replaceAll("[()]", "");
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void 특정위치_문자를_반환할_수_있다() {
        String input = "abc";
        Integer index = 1;
        Character result = input.charAt(index);
        assertThat(result).isEqualTo('b');
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    void 범위_외에_접근시_예외_발생한다(int provided) {
        String input = "abc";
        assertThatThrownBy(() -> input.charAt(provided))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
