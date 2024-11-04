package lotto.support.splitter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 분리기 테스트")
public class SplitterTest {

    @Test
    @DisplayName("쉼표로 문자열을 구분한다.")
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
}
