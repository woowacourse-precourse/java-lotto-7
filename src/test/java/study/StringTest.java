package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    // 요구사항 1
    @Test
    @DisplayName("\"1, 2\"을 ,로 split했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
    public void testSplitNumbersTest() {
        // given
        String numbers = "1,2";

        // when
        String[] number = numbers.split(",");

        // then
        assertThat(number).contains("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split했을 때 1만 포함하는 배열이 반환되는지에 대한 학습 테스트")
    public void testSplitNumberTest() {
        // given
        String numbers = "1";

        // when
        String[] number = numbers.split(",");

        // then
        assertThat(number).containsExactly("1");
    }

    // 요구사항 2
    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환하는지 확인하는 학습 테스트")
    public void testSubstringTest() {
        String numbers = "(1,2)";

        String substring = numbers.substring(1, numbers.length() - 1);

        assertEquals(substring,"1,2");
    }

    // 요구사항 3
    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    public void testCharAtTest() {
        String word = "abc";

        char firstChar = word.charAt(0);    // 'a'
        char secondChar = word.charAt(1);   // 'b'
        char lastChar = word.charAt(2);     // 'c'

        assertEquals(firstChar,'a');
        assertEquals(secondChar, 'b');
        assertEquals(lastChar, 'c');
    }
}
