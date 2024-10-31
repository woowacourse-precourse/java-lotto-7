package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    InputView inputView = new InputView();

    @ParameterizedTest
    @DisplayName("구입금액 입력 예외 발생")
    @ValueSource(strings = {"1500", "-3000", "abcd", "500", "0"})
    void checkAmount(String input) {
        assertThatThrownBy(() -> inputView.checkAmount(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("\\[ERROR] 구입금액은 1000원 단위로 입력해 주세요.");
    }
}