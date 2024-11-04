package lotto.application.util.StrinConverter;


import lotto.application.util.StringConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("StringConverter - 문자열 trim")
public class TrimTest {

    @DisplayName("문자열 앞뒤 공백 제거")
    @Test
    void 문자열_앞뒤_공백_제거() {
        // given
        String input = "   prepre ";

        // when
        String result = StringConverter.trim(input);

        // then
        Assertions.assertThat(result).isEqualTo("prepre");

    }

    @DisplayName("null이나 빈 문자열이면 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  "})
    void null이나_빈_문자열이면_예외발생(String input) {

        // expect
        Assertions.assertThatThrownBy(() -> StringConverter.trim(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
