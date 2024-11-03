package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringTest {
    @DisplayName("쉼표(,)로 문자열 split이 잘 이루어졌는지 확인")
    @Test
    void split_테스트1() {
        assertThat("1,2".split(","))
                .containsExactly("1","2");
    }

    @DisplayName("구분자가 없는 문자열 split시 그대로 반환되는지 확인")
    @Test
    void split_테스트2() {
        assertThat("1".split(","))
                .containsExactly("1");
    }

    @DisplayName("원하는 범위의 문자열을 잘 가져왔는지 확인")
    @Test
    void substring_테스트() {
        assertEquals("1,2", "(1,2)".substring(1,4));
    }

    @ParameterizedTest(name = "charAt 테스트{index} : {0}.charAt({1}) == {2}")
    @CsvSource({
                "'abc', 0, 'a'",
                "'abc', 1, 'b'",
                "'abc', 2, 'c'"
            })
    void charAt_테스트1(String str, int idx, char result) {
        assertEquals(result, str.charAt(idx));
    }

    @DisplayName("문자열의 범위를 벗어난 charAt의 예외 테스트")
    @Test
    void charAt_테스트2() {
        String testStr = "abc";
        
        assertThatThrownBy(() -> {
            testStr.charAt(-1);
        }).isInstanceOf(IndexOutOfBoundsException.class);

        assertThatThrownBy(() -> {
            testStr.charAt(testStr.length());
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
