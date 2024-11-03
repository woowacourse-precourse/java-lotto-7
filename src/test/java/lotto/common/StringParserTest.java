package lotto.common;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.common.StringParser;

class StringParserTest {

    @Test
    void parseInt() {
        assertThat(StringParser.parseInt("1")).isEqualTo(1);
        assertThat(StringParser.parseInt("3")).isEqualTo(3);
        assertThat(StringParser.parseInt("0")).isEqualTo(0);
        assertThat(StringParser.parseInt("-1")).isEqualTo(-1);
        assertThat(StringParser.parseInt("123")).isEqualTo(123);
    }

    @Test
    void parseInt_숫자가_아닌_문자열() {
        String[] failCases = {"", "word", "문자", "1a", "a1"};

        for (String failCase : failCases) {
            assertThatThrownBy(() -> StringParser.parseInt(failCase))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void parseIntListByComma() {
        assertThat(StringParser.parseIntListByComma("1,2,3,4"))
            .containsExactly(1, 2, 3, 4);
        assertThat(StringParser.parseIntListByComma("133"))
            .containsExactly(133);
        assertThat(StringParser.parseIntListByComma("0,1,-1"))
            .containsExactly(0,1,-1);
    }

    @Test
    void parseIntListByComma_시작_또는_끝이_comma() {
        assertThatThrownBy(() -> StringParser.parseIntListByComma("1,2,3,"))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> StringParser.parseIntListByComma(",1,2,3,"))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> StringParser.parseIntListByComma(",1,2,3"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}