package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    @Test
    @DisplayName("1000의 배수가 아닌 금액이 입력되면 예외가 발생한다.")
    void invalid_money_test1() {
        assertThatThrownBy(() -> Input.parseMoney("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0이하의 금액이 입력되면 예외가 발생한다.")
    void invalid_money_test2() {
        assertThatThrownBy(() -> Input.parseMoney("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Input.parseMoney("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("제대로된 입력 검증 테스트")
    void valid_input_test() {
        assertThat(Input.parseMoney("1000")).isEqualTo(1000);
    }
}
