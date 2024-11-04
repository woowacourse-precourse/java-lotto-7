package lotto.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class StringParserTest {

    @Test
    @Order(1)
    void toInteger() {
        assertThat(StringParser.toInteger("1")).isEqualTo(1);
        assertThatThrownBy(()->StringParser.toInteger("string"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효한 숫자를 입력해야 합니다.");
    }

    @Test
    @Order(2)
    void toNumericsSplitBy() {
        assertThat(StringParser.toNumericsSplitBy("1,2,3",",")).isEqualTo(List.of(1,2,3));
        assertThatThrownBy(()->StringParser.toNumericsSplitBy("1,2#3",","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효한 숫자를 입력해야 합니다.");
    }
}
