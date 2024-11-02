package lotto.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @BeforeEach
    void setUp() {
        InputStream standardIn = System.in;
    }

    private void setInput() {
        System.setIn(new ByteArrayInputStream("8000\n".getBytes()));
    }

    @DisplayName("구입금액 입력 확인")
    @Test
    void 구입금액_입력_테스트() {
        setInput();
        int amount = InputView.inputPurchaseAmount();
        assertThat(amount).isEqualTo(8000);
    }

    @DisplayName("구입금액 입력 문자 포함 예외")
    @Test
    void 구입금액_입력_문자_포함() {
        String amount = "abcd";
        assertThatThrownBy(() -> InputView.validate(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 숫자로 입력해야 합니다.");
    }

    @DisplayName("구입금액 입력 1000원 단위 테스트")
    @Test
    void 구입금액_입력_1000원_단위() {
        String amount = "2500";
        assertThatThrownBy(() -> InputView.validate(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.");
    }
}
