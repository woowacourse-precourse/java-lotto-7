package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"를 콤마로 split한 배열은 \"1\", \"2\"를 포함해야한다")
    void shouldSplitTextWithRegex() {
        // given
        String text = "1,2";
        String regex = ",";

        // when
        String[] splitTexts = text.split(regex);

        // then
        assertThat(splitTexts).contains("1");
        assertThat(splitTexts).contains("2");
    }

    @Test
    @DisplayName("\"1,\"를 콤마로 split한 배열은 \"1\"만 포함해야한다.")
    void whenSplitTextsIsOneToken() {
        // given
        String text = "1,";
        String regex = ",";

        // when
        String[] splitTexts = text.split(regex);

        // then
        assertThat(splitTexts).contains("1"); // containsExactly -> 요소의 순서와 개수까지 검사
    }

    @Test
    @DisplayName("\"(1,2)\"을 substring을 통해 ()을 제거하면 \"1,2\"를 반환해야한다.")
    void shouldSubstringTextWithRegex() {
        // given
        String text = "(1,2)";

        // when
        String splitTexts = text.substring(1, 4); // 인덱스 1에서 3까지의 문자열을 반환해야 함

        // then
        assertThat(splitTexts).isEqualTo("1,2");
        assertThat(splitTexts).isNotEqualTo("(1,2");
    }

    @Test
    @DisplayName("charAt을 활용해 \"abc\"의 특정 위치 문자를 가져와야한다.")
    void shouldExtractCharAtCertainIndex() {
        // given
        String text = "abc";
        int index = 0; // 'a'가 위치한 인덱스

        // when
        char charAtIndex = text.charAt(index);

        // then
        assertThat(charAtIndex).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt을 활용해 특정 위치의 문자를 가져올 때 위치값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void shouldThrowExceptionWhenIndexIsOutOfBounds() {
        // given
        String text = "abc";
        int indexOutOfBound = 3; // 범위를 벗어난 인덱스

        // when, then
        assertThrows(StringIndexOutOfBoundsException.class, () -> text.charAt(indexOutOfBound));
        assertThatThrownBy(() -> text.charAt(indexOutOfBound))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index 3 out of bounds for length 3");
    }

}
