package lotto.io.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberRequestTest {

    @DisplayName("입력은 null이거나 공백 일 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    void isNotValidInput(String input) {
        assertThatThrownBy(() -> new WinningNumberRequest(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력은 정해진 규칙에 맞아야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,d,e,f", "1:2:3:4:5:6:7", "1,2!3,4:5#6"})
    void isNotValidPattern(String input) {
        assertThatThrownBy(() -> new WinningNumberRequest(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

}