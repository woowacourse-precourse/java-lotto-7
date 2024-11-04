package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class WinningNumberParserTest {

    private static final WinningNumberParser winningNumberParser = new WinningNumberParser();

    private static final String NOT_NUMBER = "a,b,c,d,e,f";
    private static final String NOT_COMMA = "a'b'c'd'e'f";

    @Test
    void 당첨_번호에_숫자가_아닌_값이_입력된_경우_예외가_발생한다() {
        assertThatThrownBy(() -> winningNumberParser.split(NOT_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호의_구분자가_콤마가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> winningNumberParser.split(NOT_COMMA))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
