package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("split_테스트_1")
    void 문자열_Split_테스트_1() {
        String[] arr = "1,2".split(",");
        assertThat(arr).contains("1", "2");
    }

    @Test
    @DisplayName("split_테스트_2")
    void 문자열_Split_테스트_2() {
        String[] arr = "1".split(",");
        assertThat(arr).containsExactly("1");
    }

    @Test
    @DisplayName("문자열_자르기_테스트")
    void 문자열_자르기_테스트() {
        String target = "(1,2)";
        assertThat(target.substring(1, 4)).contains("1,2");
    }

    @Test
    @DisplayName("charAt()_테스트_1")
    void 문자_가져오기_테스트() {
        String target = "abc";
        assertThat(target.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt()_예외테스트_1")
    void charAt_예외테스트_1() {
        String target = "abc";
        assertThatThrownBy(() -> target.charAt(4)).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index 4 out of bounds");
    }

    @Test
    @DisplayName("charAt()_예외테스트_2")
    void charAt_예외테스트_2() {
        String target = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> target.charAt(4))
                .withMessageMatching("Index \\d+ out of bounds for length \\d+");
    }
}
