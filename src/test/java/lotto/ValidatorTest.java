package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.common.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    void 예외_테스트_구매_금액은_1000_단위로_나누어_떨어지지_않으면_실패한다() {
        int price = 2001;
        assertThatThrownBy(() -> validator.validatePrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액은 1,000원 단위로 입력해주세요.");
    }

    @Test
    void 예외_테스트_구매_금액에_0을_입력하면_실패한다() {
        int price = 0;
        assertThatThrownBy(() -> validator.validatePrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액은 양의 정수로 입력해주세요.");
    }

    @Test
    void 예외_테스트_구매_금액에_음의_정수를_입력하면_실패한다() {
        int price = -2000;
        assertThatThrownBy(() -> validator.validatePrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액은 양의 정수로 입력해주세요.");
    }

    @Test
    void 예외_테스트_구매_금액에_문자를_입력하면_실패한다() {
        String price = "오천원";
        assertThatThrownBy(() -> validator.isNumber(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자로 입력해주세요.");
    }
}