package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void 구분자로_split_했을_때_잘_분리() {
        // given
        String input = "1,2";

        // when
        String[] result = input.split(",");

        // then
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void 구분자를_포함하지_않지만_구분자로_split_했을_때_값이_배열에_반환() {
        // given
        String input = "1";

        // when
        String[] result = input.split(",");

        // then
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring_메소드를_활용해_특정_구간만을_반환() {
        // given
        String input = "(1,2)";

        // when
        String result = input.substring(1, 4);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt_메소드를_활용해_특정_위치의_문자를_반환")
    void charAt_메소드를_활용해_특정_위치의_문자를_반환() {
        // given
        String input = "abc";

        // when
        char result = input.charAt(1);

        // then
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt_메소드를_활용해_특정_위치의_문자를_찾을때_위치를_벗어나_에러_반환")
    void charAt_메소드를_활용해_특정_위치의_문자를_반환할때_위치를_벗어나_에러_반환() {
        // given
        String input = "abc";

        // when & then
        assertThatThrownBy(() -> input.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("out of bounds for length 3");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(3))
                .withMessageMatching("Index \\d+ out of bounds for length \\d+");
    }
}