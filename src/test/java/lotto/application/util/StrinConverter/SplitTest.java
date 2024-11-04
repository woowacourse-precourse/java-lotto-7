package lotto.application.util.StrinConverter;


import lotto.application.util.StringConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("StringConverter - 문자열 split")
public class SplitTest {

    @DisplayName("문자열을 , 기준으로 자르기")
    @Test
    void 문자열열_쉼표_기준으로_자르기() {
        // given
        String input = "1,2,3";

        // when
        String[] result = StringConverter.split(input);

        // then
        Assertions.assertThat(result).containsExactly("1", "2", "3");
    }

    @DisplayName("null이나 빈 문자열이면 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  "})
    void null이나_빈_문자열이면_예외발생(String input) {

        // expect
        Assertions.assertThatThrownBy(() -> StringConverter.split(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
