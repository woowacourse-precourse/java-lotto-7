package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MoneyTest {

    Validator validator = new Validator();

    @Test
    @DisplayName("돈의 유효성 검사 - 1000원 단위로 나누어 떨어지지 않는 경우")
    void 돈의_단위_유효성_검사() {
        String money = "1500";

        assertThatThrownBy(() -> validator.validateMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("돈의 유효성 검사 - 숫자가 양수가 아닌 경우")
    void 돈의_범위_유효성_검사() {
        String money = "-1500";

        assertThatThrownBy(() -> validator.validateMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
