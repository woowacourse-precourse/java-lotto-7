package study;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class StringTest {

    /**
     * 요구사항 1 "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     * "1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     * ---------------------------------------------------------------------------------
     * 주어진 구분자가 문자열 내에 없을 경우, 전체 문자열을 하나의 요소로 간주하여 반환한다.
     */
    @Test
    @DisplayName("split 메서드로 주어진 값을 구분")
    void splitTest() {
        //given
        String input1 = "1,2,3";
        String input2 = "1";

        //when
        String[] result1 = input1.split(",");
        String[] result2 = input2.split(",");

        //then
        assertThat(result1).contains("1", "2");
//        assertThat(result1).containsExactly("1", "2");
        assertThat(result2).contains("1");
        assertThat(result2).containsExactly("1");

    }

    /**
     * 요구사항 2
     * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환
     * 하도록 구현한다.
     */
    @Test
    @DisplayName("substring 메서드로 특정 구간 값을 반환")
    void substringTest() {
        //given
        String input = "(1,2)";

        //when
        String result = input.substring(1, input.length() - 1);

        //then
        assertThat(result).isEqualTo("1,2");
    }

    /**
     * 요구사항 3
     * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습
     * 테스트를 구현한다.
     * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
     * StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
     * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     *
     */
    @Test
    @DisplayName("charAt 메서드로 문자열에서 특정 위치의 문자를 반환")
    void charAtTest(){
        //given
        String input = "abc";
        //when
        char ch1 = input.charAt(0);
        char ch2 = input.charAt(1);
        char ch3 = input.charAt(2);

        //then
        assertThat(ch1).isEqualTo('a');
        assertThat(ch2).isEqualTo('b');
        assertThat(ch3).isEqualTo('c');
    }

    @Test
    @DisplayName("assertThatThrownByTest 메서드로 특정 위치 값을 벗어나면 발생하는 예외 처리")
    void assertThatThrownByTest1(){
        // given
        String input = "abc";

        // when & then
        assertThatThrownBy(() -> input.charAt(input.length()))  // 유효하지 않은 인덱스로 예외 발생시킴
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index 3 out of bounds for length 3");
    }

    @Test
    @DisplayName("assertThatThrownByTest 메서드로 StringIndexOutOfBoundsException을 직접 생성")
    void assertThatThrownByTest2(){
        String input = "abc";
        int invalidIndex = input.length();
        int size = input.length();

        assertThatThrownBy(() -> {
            throw new StringIndexOutOfBoundsException("Index: " + invalidIndex + ", Size: " + size);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 3, Size: 3");
    }

    @Test
    @DisplayName("assertThatExceptionOfTypeTest 메서드로 ")
    void assertThatExceptionOfTypeTest(){
        //given
        String input = "abc";
        int invalidIndex = input.length();
        int size = input.length();

        //when & then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(invalidIndex))
                .withMessageMatching("Index \\d+ out of bounds for length \\d+")
                .withMessageContaining("Index 3");
    }
}
