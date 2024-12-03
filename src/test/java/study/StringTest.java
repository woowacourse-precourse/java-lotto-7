package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIndexOutOfBoundsException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    /*
    요구사항 1
    "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    "1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     */

    @DisplayName("split 문자열을 콤마를 기준으로 분리해야한다")
    @Test
    void testShouldParseCsvString() {
        // given
        String input = "1,2";

        // when
        String[] parsed = input.split(",");

        // then
        assertThat(parsed).contains("1");
        assertThat(parsed).contains("2");
    }

    @DisplayName("split은 하나의 문자도 구분해야한다.")
    @Test
    void testShouldParseExactlyOne() {
        // given
        String input = "1";

        // when
        String[] parsed = input.split(",");

        // then
        assertThat(parsed).containsExactly("1"); // containsExactly는 갯수 뿐 아니라 순서까지 확인
    }

    /*
    요구사항 2
    "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환
    하도록 구현한다.
     */
    @DisplayName("substring을 활용한 기준 문자열 반환")
    @Test
    void testSubstring() {
        // given
        String input = "(1,2)";

        // when
        String substring = input.substring(1, 4);

        assertThat(substring).isEqualTo("1,2");
    }

    /*
    요구사항 3
    "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습
    테스트를 구현한다.
    String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
    StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
    JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     */
    @DisplayName("특정 위치의 문자를 가져온다")
    @Test
    void testShouldGetCharFromIndex() {
        // given
        String input = "abc";

        // when
        // then
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> input.charAt(input.length()))
                .isInstanceOf(IndexOutOfBoundsException.class);

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(-1));

    }
}
