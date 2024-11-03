package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @DisplayName("split 으로 값을 분리한다.")
    @Test
    void splitTest() {
        String input = "1,2";

        String[] separatedInput = input.split(",");

        assertThat(separatedInput).contains("1", "2");
        assertThat(separatedInput).containsExactly("1", "2");
    }

    @DisplayName("substring 으로 괄호를 제거한다.")
    @Test
    void substringTest() {
        String input = "(1,2)";

        String parenthesesRemovedInput = input.substring(1, 4);

        assertThat(parenthesesRemovedInput).isEqualTo("1,2");
    }

    @DisplayName("charAt 으로 특정 위치의 문자를 가져온다.")
    @Test
    void charAtTest() {
        String input = "abc";

        char extractedInput = input.charAt(0);

        assertThat(extractedInput).isEqualTo('a');
    }

    @DisplayName("charAt 범위를 벗어난 위치 값이 들어오면 예외가 발생한다.")
    @Test
    void charAtExceptionTest() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
