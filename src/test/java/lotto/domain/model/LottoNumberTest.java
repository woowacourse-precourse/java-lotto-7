package lotto.domain.model;

import lotto.exception.message.Error;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    @DisplayName("지정된 범위를 벗어난 숫자를 입력하면 예외다")
    void throws_when_input_is_invalid_range() {
        int invalidTestNumber = 55;

        Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoNumber(invalidTestNumber));
    }

    @Test
    @DisplayName("지정된 범위를 벗어난 숫자를 입력하면 해당 예외 문구가 뜬다")
    void throws_illegal_exception_when_input_is_invalid_range() {
        int invalidTestNumber = 55;

        org.assertj.core.api.Assertions.assertThatThrownBy(() -> new LottoNumber(invalidTestNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.INVALID_RANGE.formatMessageOf(1, 45));
    }
}
