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

    @ParameterizedTest
    @DisplayName("당첨 번호 입력 예외 발생")
    @ValueSource(strings = {"0", "46", "a", "-1"})
    void checkInputLottoNumbers(String input) {
        assertThatThrownBy(() -> inputView.checkInputLottoNumbers(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("\\[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}