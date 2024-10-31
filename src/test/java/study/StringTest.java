package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("`1,2`를 ,로 스플릿하면 1과 2를 포함하는 배열이 반환된다.")
    @Test
    void splitTest() {
        // given
        String str = "1,2";

        // when
        String[] arr = str.split(",");

        // then
        assertThat(arr).contains("1");
        assertThat(arr).contains("2");
        assertThat(arr).containsExactly("1", "2");
    }

    @DisplayName("`1`을 ,로 스플릿하면 1만을 포함하는 배열이 반환된다.")
    @Test
    void splitSingleElementTest() {
        // given
        String str = "1";

        // when
        String[] arr = str.split(",");

        // then
        assertThat(arr).containsExactly("1");
    }

    @DisplayName("`(1,2)` 값에서 substring() 메소드를 사용해 괄호를 제거하고 `1,2`만 반환한다.")
    @Test
    void substringTest() {
        // given
        String str = "(1,2)";

        // when
        String result = str.substring(1, str.length() - 1);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("`abc` 문자열에서 특정 위치의 문자를 가져올 수 있다.")
    @Test
    void charAtTest() {
        // given
        String str = "abc";

        // when & then
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
    }

    @DisplayName("charAt() 메소드를 사용할 때 범위를 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    @Test
    void charAtOutOfBoundsTest() {
        // given
        String str = "abc";

        // when & then
        assertThatThrownBy(() -> str.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index 3 out of bounds for length 3");
    }
}
