package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParseTest {

    @DisplayName("문자열을 정수로 변환 할 수 없으면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "100j", " ", "1,1", ""})
    void 정수_변환_불가시_예외를_던진다(String input) {
        Assertions.assertThatThrownBy(() -> Parse.stringToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자로 변환할 수 없습니다.");
    }

}
