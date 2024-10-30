package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("콤마가 포함된 문자열을 split()")
    public void splitComma() {
        // given
        String src = "1,2";

        // when
        String[] result = src.split(",");

        // then
        assertThat(result.length)
                .isEqualTo(2);
        assertThat(result)
                .contains("1", "2");
    }

    @Test
    @DisplayName("콤마가 없는 문자열을 split()")
    public void splitComma2() {
        // given
        String src = "1";

        // when
        String[] result = src.split(",");

        // then
        assertThat(result.length)
                .isEqualTo(1);
        assertThat(result)
                .containsExactly("1");
    }

    @Test
    public void substringBracket() {
        // given
        String src = "(1,2)";

        // when
        String result = src.substring(1, 4);

        // then
        assertThat(result)
                .isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt()을 사용할 때 위치 값을 벗어났을 경우")
    public void charAt() {
        // given
        String src = "abc";

        // when, then
        assertThatThrownBy(() -> {
            src.charAt(src.length());
        })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index %d", 3)
                .hasMessageContaining("length %d", 3);
    }
}
