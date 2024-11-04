package lotto.util;

import java.math.BigDecimal;
import lotto.exception.ErrorMessages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParseTest {

    @DisplayName("문자열을 정수로 변환 할 수 없으면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "100j", " ", "1,1", ""})
    void 정수_변환_불가시_예외를_던진다(String input) {
        Assertions.assertThatThrownBy(() -> Parse.stringToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_LOTTO_PRICE_TYPE.getMessage());
    }

    @DisplayName("숫자를 콤마로 포맷팅한다.")
    @Test
    void 숫자_콤마_포맷팅() {
        String formatted1 = Parse.formatWithCommas(BigDecimal.valueOf(1));
        String formatted2 = Parse.formatWithCommas(BigDecimal.valueOf(1_000));
        String formatted3 = Parse.formatWithCommas(BigDecimal.valueOf(1_000_000));
        String formatted4 = Parse.formatWithCommas(BigDecimal.valueOf(1_000_000_000));

        Assertions.assertThat(formatted1).isEqualTo("1");
        Assertions.assertThat(formatted2).isEqualTo("1,000");
        Assertions.assertThat(formatted3).isEqualTo("1,000,000");
        Assertions.assertThat(formatted4).isEqualTo("1,000,000,000");
    }

}
