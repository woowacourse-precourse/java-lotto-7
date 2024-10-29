package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constant.ErrorMessage.PRICE_TYPE_ERROR;
import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        validator = new Validator();
    }

    @Test
    @DisplayName("숫자 형식이 아닌 입력이 들어오면 예외를 발생시킨다.")
    void 금액_입력_예외_테스트_1() throws Exception {
        // given
        String price = "aaa";

        // when
        boolean result = validator.validatePrice(price);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("1000원 보다 작은 입력이 들어온 경우 예외를 발생시킨다")
    void 금액_입력_예외_테스트_2() throws Exception {
        // given
        String price = "100";

        // when
        boolean result = validator.validatePrice(price);

        // then
        assertThat(result).isFalse();
    }


}
