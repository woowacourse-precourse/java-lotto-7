package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @DisplayName("String.split() 메소드 - '1,2'를 ','로 split 했을 때 1과 2로 잘 분리되는지 확인")
    @Test
    void 컴마_분리_테스트() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("String.split() 메소드 - '1'을 ','로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    @Test
    void 단일_문자_컴마_분리_테스트() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("String.substring() 메소드 - '(1,2)'에서 괄호를 제거하고 '1,2'를 반환하도록 테스트")
    @Test
    void substring함수_괄호_제거_테스트() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("String.charAt() 메소드 - 'abc'에서 특정 위치의 문자를 가져오는 테스트")
    @Test
    void charAt함수_특정_위치_문자_테스트() {
        String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @DisplayName("String.charAt() 메소드 - 'abc'에서 위치 값을 벗어날 때 StringIndexOutOfBoundsException 발생 테스트")
    @Test
    void charAt_outOfBounds_shouldThrowException() {
        String input = "abc";
        assertThatThrownBy(() -> input.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 3, Size: 3");
    }
}
