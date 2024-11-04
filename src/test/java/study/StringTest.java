package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void 문자열_분리_테스트() {
        assertThat("1,2".split(",")).contains("1", "2");
        assertThat("1".split(",")).contains("1");
    }

    @Test
    void 문자열_제거_테스트() {
        assertThat("(1,2)".substring(1,4)).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져올 때 위치의 값을 벗어나면 예외가 발생한다.")
    @Test
    void 특정_위치의_문자를_가져올_때_위치의_값을_벗어나면_예외가_발생한다() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(3));
    }
}