package lotto.util;

import lotto.vo.Payment;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserTest {
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
