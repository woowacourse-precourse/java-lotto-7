package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @DisplayName("inputParser_메서트_테스트_01")
    @Test
    void 쉼표를_구분자로_하여_당첨_번호를_분리한다() {
        String input = "1,3,4,5,6";
        List<String> expected = Arrays.asList("1", "3", "4", "5", "6");

        assertThat(Parser.inputParser(input)).containsExactlyElementsOf(expected);
    }
}
