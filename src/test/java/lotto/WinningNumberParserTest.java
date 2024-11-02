package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class WinningNumberParserTest {
    @Test
    public void 쉼표를_구분자로_하여_문자열을_분리한다() {
        String input = "1,4,8,5,44,43";
        List<Integer> expected = List.of(1, 4, 8, 5, 44, 43);
        List<Integer> actual = WinningNumberParser.parse(input);
        assertEquals(expected, actual);
    }
}
