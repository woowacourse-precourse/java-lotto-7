package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

    @Test
    @DisplayName("String::split - 1,2을 , 로 split 했을 때 1과 2로 분리된다.")
    void splitSuccess1() {
        // given
        String testString = "1,2";
        // when
        String[] result = testString.split(",");
        // then
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String::split - 1을 , 로 split 했을 때 1만 포함하는 배열이 나온다.")
    void splitSuccess2() {
        // given
        String testString = "1";
        // when
        String[] result = testString.split(",");
        // then
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("String::substring - (1,2) 값이 주어졌을 때 () 을 제거하고 1,2를 반환한다.")
    void substringSuccess() {
        // given
        String testString = "(1,2)";
        // when
        String substring = testString.substring(1, 4);
        // then
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String::charAt - 문자길이의 범위 안으로 입력하면 특정 위치의 문자를 가져온다.")
    void charAtSuccess() {
        // given
        String testString = "abc";
        // when
        char a = testString.charAt(0);
        char b = testString.charAt(1);
        char c = testString.charAt(2);
        // then
        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3, 100})
    @DisplayName("String::charAt - 문자길이의 범위 밖으로 입력하면 StringIndexOutOfBoundsException 예외가 발생한다.")
    void chatAtFailBecauseOfRangeWithValueSourceAnnotation(int index) {
        // given
        String testString = "abc";
        // when & then
        assertThatThrownBy(() -> testString.charAt(index)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("String::charAt - 문자길이의 범위 밖으로 입력하면 특정 메시지를 가진 예외가 터진다.(단일 테스트)")
    void chatAtFailBecauseOfRangeWithTestAnnotation() {
        // given
        String testString = "abc";
        // when & then
        assertThatThrownBy(() -> testString.charAt(-1)).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("Index -1 out of bounds for length 3");
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> testString.charAt(-1))
                .withMessageMatching("Index -?\\d+ out of bounds for length \\d+");
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("String::charAt - 문자길이의 범위 밖으로 입력하면 특정 메시지를 가진 예외가 터진다.(파라미터 테스트)")
    void chatAtFailBecauseOfRangeWithMethodSourceAnnotation(int index) {
        // given
        String testString = "abc";
        // when & then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> testString.charAt(index))
                .withMessageMatching("Index -?\\d+ out of bounds for length \\d+");
    }

    static Stream<Integer> chatAtFailBecauseOfRangeWithMethodSourceAnnotation() {
        return Stream.of(-1, 100, 3, 4, -100);
    }
}

