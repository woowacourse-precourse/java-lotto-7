package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringSplitterTest {

    @Test
    @DisplayName("주어진 문자열을 구분자로 나누는지 확인합니다.")
    void 구분자_구분_확인() {
        String TestInput = "1,2,3,4,5,6";
        List<String> answer = new ArrayList<>(List.of("1", "2", "3", "4", "5", "6"));
        assertThat(StringSplitter.splitByDelimiter(TestInput, ",")).isEqualTo(answer);
    }
}
