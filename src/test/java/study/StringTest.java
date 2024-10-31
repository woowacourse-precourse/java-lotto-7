package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringTest {

    private static final String DELIMITER = ",";

    @Test
    void 구분자를_기준으로_문자열을_분리해_배열을_반환한다() {
        String stringWithDelimiter = "1,2";
        String[] splitByDelimiter = stringWithDelimiter.split(DELIMITER);

        // contains()
        // -> 포함 여부만 확인. 순서는 상관없음
        assertThat(splitByDelimiter).contains("1", "2");
        assertThat(splitByDelimiter).contains("2", "1");
        assertThat(splitByDelimiter).contains("1");
    }

    @Test
    void 구분자가_포함되지_않았으면_그대로_배열을_반환한다() {
        String stringNoDelimiter = "1";
        String[] splitByDelimiter = stringNoDelimiter.split(",");

        // containsExactly()
        // -> 순서를 포함해 정확히 일치해야 함
        assertThat(splitByDelimiter).containsExactly("1");
    }

    @Test
    void 순서와_값이_일치하지_않으면_예외가_발생한다() {
        // === 추가 공부 : containsExactly ===
        String additionalStudy = "1,2,3,2,1";
        String[] additionalStudySplit = additionalStudy.split(",");
        assertThat(additionalStudySplit).containsExactly("1","2","3","2","1");

        // 중복된 값까지 순서에 맞게 처리되어야 함
        assertThrows(AssertionError.class, () ->
                assertThat(additionalStudySplit).containsExactly("1","2","3")
        );

        assertThrows(AssertionError.class, () ->
                assertThat(additionalStudySplit).containsExactly("1","2","3","1","2")
        );
    }

    @Test
    void 문자열에서_특정_부분만을_추출해_반환한다() {
        String s = "(1,2)";
        String subString = s.substring(1, s.length() - 1);
        assertThat(subString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열에서 특정 문자를 반환한다")
    void charAtTest() {
        String s = "abc";
        char[] expectedChars = {'a', 'b', 'c'};

        for (int i = 0; i < s.length(); i++) {
            assertThat(s.charAt(i)).isEqualTo(expectedChars[i]);
        }
    }

    @Test
    @DisplayName("인덱스가 위치 값을 벗어나면 예외가 발생한다")
    void charAtExceptionTest() {
        String s = "abc";

        assertThatThrownBy(() -> s.charAt(-1))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("out of bounds");
    }
}
