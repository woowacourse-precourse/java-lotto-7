package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).contains("1", "2");
    }

    @Test
    void split_메서드_구분자가_없는_경우() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).contains("1");
    }

    @Test
    void substring_메서드로_특정_구간_값을_반환() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt_메소드로_특정_위치의_문자_찾기() {
        String input = "abc";
        char charAtElement = input.charAt(0);
        assertThat(charAtElement).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt_메서드_인덱스_초과_예외")
    void charAt_메서드_사용시_인자가_문자열의_인덱스보다_클때() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(10))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index 10 out of bounds for length 3");
    }


    @Test
    @DisplayName("charAt_메서드_인덱스_미만_예외")
    void charAt_메서드_사용시_인자가_문자열의_인덱스보다_작을때() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(-1))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index -1 out of bounds for length 3");
    }
}
