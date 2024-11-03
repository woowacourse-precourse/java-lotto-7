package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void 쉼표로_split_했을_때_잘_분리된다() {
        assertThat("1,2".split(",")).contains("1", "2");
    }

    @Test
    void 쉼표가_없는_경우에도_쉼표로_split_했을_때_잘_분리된다() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void 괄호_제거_후_문자열_반환() {
        String value = "(1,2)";
        String string = value.substring(1, value.length() - 1);
        assertThat(string).isEqualTo("1,2");
    }

    @DisplayName("charAt() 메소드 사용 시, 위치 값이 벗어나면 예외가 발생한다.")
    @Test
    void charAt_테스트() {
        String value = "abc";
        assertThatThrownBy(() -> value.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
