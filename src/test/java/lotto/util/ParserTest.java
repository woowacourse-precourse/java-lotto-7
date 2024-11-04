package lotto.util;

import lotto.vo.Payment;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    void 문자열_정수_정상_파싱() {
        int parsedNum = Parser.parseStringToInt("5");
        assertEquals(parsedNum, 5);
    }

    @Test
    void 문자열_분리() {
        List<String> parsed = Parser.parseElements("0,1");
        assertEquals("0", parsed.get(0));
        assertEquals("1", parsed.get(1));
    }

    @Test
    void 인티저_범위_초과() {
        assertThatThrownBy(() -> Parser.parseStringToInt("2147483648"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 롱_범위_초과() {
        assertThatThrownBy(() -> Parser.parseStringToInt("1111111111111111111"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 파싱_불가_요소_포함() {
        assertThatThrownBy(() -> Parser.parseStringToInt("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
