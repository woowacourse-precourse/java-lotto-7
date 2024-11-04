package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIndexOutOfBoundsException;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    @DisplayName("1,2를 ,(쉼표) 기준으로 split 한다.")
    void stringTest1() throws Exception {
        //given
        final String input = "1,2";
        final String regex = ",";

        //when
        final String[] split = input.split(regex);

        //then
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1,를 ,(쉼표) 기준으로 split 하면 1만 포함 하는 배열이 반환 된다.")
    void stringTest2() throws Exception {
        //given
        final String input = "1,";
        final String regex = ",";

        //when
        final String[] split = input.split(regex);

        //then
        assertThat(split).contains("1");
    }

    @Test
    @DisplayName("(1,2) 값의 ()를 제거하고 1,2를 반환 한다.")
    void stringTest3() throws Exception {
        //given
        final String input = "(1,2)";

        //when
        final String substring = input.substring(1, input.length() - 1);

        //then
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc 에서 특정 위치의 문자를 가져온다.")
    void stringTest4() throws Exception {
        //given
        final String input = "abc";

        //when
        final char c1 = input.charAt(0);
        final char c2 = input.charAt(1);
        final char c3 = input.charAt(2);

        //then
        assertAll(
                () -> assertThat(c1).isEqualTo('a'),
                () -> assertThat(c2).isEqualTo('b'),
                () -> assertThat(c3).isEqualTo('c')
        );
    }

    @Test
    @DisplayName("abc 특정 위치가 문자열 길이를 벗어나 예외가 발생한다.")
    void stringTest5() throws Exception {
        //given
        final String input = "abc";

        //should
        assertThatIndexOutOfBoundsException().isThrownBy(() -> input.charAt(5))
                .withMessageContaining("Index 5 out of bounds for length 3");
    }
}
