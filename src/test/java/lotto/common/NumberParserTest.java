package lotto.common;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberParserTest {

    @DisplayName("숫자가 아닌 문자열을 입력할 경우 예외를 발생시킨다.")
    @Test
    void validateNumberFormat() {
        assertThatThrownBy(() -> NumberParser.toInt("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
