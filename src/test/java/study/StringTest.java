package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @DisplayName("1,2 을 ,로 구분 테스트")
    @Test
    void splitBySeparatorWithContains() {

        // given
        String str = "1,2";

        // when
        String[] splitStr = str.split(",");

        // then
        assertThat(splitStr).contains("1", "2");
        assertThat(splitStr).containsExactly("1", "2");
    }

    @DisplayName("입력값 (1,2)에서 () 제거 테스트")
    @Test
    void remove() {

        // given
        String str = "(1,2)";

        // when
        String _str = str.substring(1, str.length() - 1);

        // then
        assertThat(_str).isEqualTo("1,2");
    }

    @DisplayName("chatAt() 메소드를 활용해 특정 문자 가져오는 학습 테스트")
    @Test
    void test() {

        // given
        String str = "abc";

        // when
        int strLength = str.length();

        // then
        char lastChar = str.charAt(strLength - 1);
        assertThat(lastChar).isEqualTo('c');

        assertThatThrownBy(() -> {
            str.charAt(strLength + 1);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index 4 out of bounds for length 3");

    }
}