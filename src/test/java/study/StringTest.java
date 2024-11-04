package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void spit_테스트_1() {
        String input = "1,2";
        String[] splited = input.split(",");
        assertThat(splited).containsExactly("1", "2");
    }

    @Test
    void spit_테스트_2() {
        String input = "1";
        String[] splited = input.split(",");
        assertThat(splited).containsExactly("1");
    }

    @Test
    void substring_테스트() {
        String input = "(1,2)";
        String cutInput = input.substring(1, input.length() - 1);
        assertThat(cutInput).isEqualTo("1,2");
    }

    @DisplayName("chatAt() 메서드는 해당 인덱스의 문자를 가져온다. ")
    @Test
    void charAt_테스트_1() {
        String input = "abc";
        char letter = input.charAt(1);
        assertThat(letter).isEqualTo('b');
    }

    @DisplayName("chatAt() 메서드를 사용하여 문자열의 인덱스를 벗어나는 값을 가져오려고 할 때 예외를 발생한다. ")
    @Test
    void charAt_테스트_2() {
        String input = "abc";
        int inputLength = input.length();
        int targetIndex = 5;
        assertThatThrownBy(() -> input.charAt(targetIndex))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage(String.format("Index %d out of bounds for length %d", targetIndex, inputLength));
    }

    @DisplayName("chatAt() 메서드를 사용하여 문자열의 인덱스를 벗어나는 값을 가져오려고 할 때 예외를 발생한다. ")
    @Test
    void charAt_테스트_3() {
        String input = "abc";
        int targetIndex = 5;
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> input.charAt(targetIndex))
                .withMessageMatching("Index \\d+ out of bounds for length \\d+");
    }


}
