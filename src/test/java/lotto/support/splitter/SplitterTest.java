package lotto.support.splitter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.splitter.InvalidTextException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 분리기 테스트")
public class SplitterTest {

    @Test
    @DisplayName("쉼표로 문자열을 구분한다")
    void 성공_문자열구분() {
        // Given
        Splitter splitter = new Splitter(",");
        String text = "mint,dobby";

        // When
        List<String> splitted = splitter.split(text);

        // Then
        assertThat(splitted)
                .hasSize(2)
                .isEqualTo(List.of("mint", "dobby"));
    }

    @Test
    @DisplayName("빈 문자열이면 예외가 발생한다")
    void 실패_문자열구분_빈문자열() {
        // Given
        Splitter splitter = new Splitter(",");
        String text = "";

        // When & Then
        assertThatThrownBy(() -> splitter.split(text))
                .isInstanceOf(IllegalArgumentException.class)
                .isExactlyInstanceOf(InvalidTextException.class)
                .hasMessageContaining("빈 문자열이거나 공백일 수 없습니다");
    }

    @Test
    @DisplayName("공백이면 예외가 발생한다")
    void 실패_문자열구분_공백() {
        // Given
        Splitter splitter = new Splitter(",");
        String text = " ";

        // When & Then
        assertThatThrownBy(() -> splitter.split(text))
                .isInstanceOf(IllegalArgumentException.class)
                .isExactlyInstanceOf(InvalidTextException.class)
                .hasMessageContaining("빈 문자열이거나 공백일 수 없습니다");
    }

    @Test
    @DisplayName("null이면 예외가 발생한다")
    void 실패_문자열구분_null() {
        // Given
        Splitter splitter = new Splitter(",");
        String text = null;

        // When & Then
        assertThatThrownBy(() -> splitter.split(text))
                .isInstanceOf(IllegalArgumentException.class)
                .isExactlyInstanceOf(InvalidTextException.class)
                .hasMessageContaining("null일 수 없습니다");
    }
}
