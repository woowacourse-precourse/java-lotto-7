package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @DisplayName("구분자가 있을 때 split 했을때 테스트")
    @Test
    void 구분자가_있을_때_split_했을때_테스트() {
        // given
        String string = "1,2";

        // when
        String[] result = string.split(",");

        // then
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("구분자가 없을 때 split 했을때 테스트")
    @Test
    void 구분자가_없을_때_split_했을때_테스트() {
        // given
        String string = "1";

        // when
        String[] result = string.split(",");

        // then
        assertThat(result).containsExactly("1");
    }

    @DisplayName("substring 테스트")
    @Test
    void substring_테스트() {
        // given
        String string = "(1,2)";

        // when
        String result = string.substring(1, 4);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 메소드는 특정 위치의 문자를 가져온다")
    @Test
    void charAt_메소드는_특정_위치의_문자를_가져온다() {
        // given
        String string = "abc";

        // when
        char result = string.charAt(1);

        // then
        assertThat(result).isEqualTo('b');
    }

    @DisplayName("charAt 메소드는 위치를 벗어나면 예외가 발생한다")
    @Test
    void charAt_메소드는_위치를_벗어나면_예외가_발생한다() {
        // given
        String string = "abc";

        // when then
        assertThatThrownBy(() -> string.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index 3")
                .hasMessageMatching("^Index 3.*");

    }


}
