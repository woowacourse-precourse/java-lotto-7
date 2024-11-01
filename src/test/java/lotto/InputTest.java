package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    @Test
    @DisplayName("1000의 배수가 아닌 금액이 입력되면 예외가 발생한다.")
    void 천의_배수가_아닌_금액_입력_시_예외_발생() {
        assertThatThrownBy(() -> Input.parseMoney("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0이하의 금액이 입력되면 예외가 발생한다.(음수 포함)")
    void 숫자가_아닌_문자_입력_시_예외_발생() {
        assertThatThrownBy(() -> Input.parseMoney("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("제대로된 입력 검증 테스트")
    void 제대로된_금액_입력_시_int_반환() {
        assertThat(Input.parseMoney("1000")).isEqualTo(1000);
    }
}
