package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증")
    void 여러_개의_문자를_구분자로_분리() {
        String input = "1,2";
        assertThat(input.split(",")).containsExactly("1", "2");
    }

    @Test
    void 하나의_문자를_구분자로_분리() {
        String input = "1";
        assertThat(input.split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증")
    void 처음과_끝_괄호_없애기() {
        String input = "(1,2)";
        assertThat(input.substring(1, input.length() - 1)).contains("1,2");
    }

    @Test
    void 특정_위치의_문자_가져오기() {
        String input = "abc";
        assertEquals('a', input.charAt(0));
        assertEquals('b', input.charAt(1));
        assertEquals('c', input.charAt(2));
    }

    @Test
    @DisplayName("문자가 존재하지 않는 위치에 접근하면 StringIndexOutOfBoundsException이 발생한다.")
    void 범위를_벗어난_문자_가져오기_예외() {
        String input = "abc";

        assertThatThrownBy(() -> {
            input.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    input.charAt(4);
                });
    }

}
