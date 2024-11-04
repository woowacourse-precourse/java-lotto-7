package lotto.util;

import lotto.exception.ExceptionMessage;
import lotto.exception.InvalidLottoException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class ParserUtilTest {
    @Test
    void parseInt_유효() {
        int result = ParserUtil.parseInt("123");
        assertThat(result).isEqualTo(123);
    }

    @Test
    void parseInt_값이_숫자가_아니면() {
        assertThatThrownBy(() -> ParserUtil.parseInt("abc"))
                .isInstanceOf(InvalidLottoException.class)
                .hasMessage(ExceptionMessage.ERROR_NOT_INTEGER.getMessage());
    }

    @Test
    void parseWinningNumbers_유효() {
        List<Integer> result = ParserUtil.parseWinningNumbers("1, 2, 3, 4, 5, 6");
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void parseWinningNumbers_값이_숫자가_아니면() {
        assertThatThrownBy(() -> ParserUtil.parseWinningNumbers("1, 2, abc"))
                .isInstanceOf(InvalidLottoException.class)
                .hasMessage(ExceptionMessage.ERROR_NOT_INTEGER.getMessage());
    }
}
