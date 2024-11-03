package validator;

import lotto.validator.LottoPurchaseValidator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseValidatorTest {
    @Test
    void 구입금액_1000원_단위_테스트() {
        assertThatThrownBy(() -> LottoPurchaseValidator.validateAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
    }

    @Test
    void 구입금액_0이하__테스트() {
        assertThatThrownBy(() -> LottoPurchaseValidator.validateAmount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1원 이상의 양수로 입력해야 합니다.");
    }

    @Test
    void 너무_큰_금액_테스트() {
        assertThatThrownBy(() -> LottoPurchaseValidator.validateAmount(1000000001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액이 너무 큽니다. 다시 입력해 주세요.");
    }
    @Test
    void 정상_입력_테스트() {
        LottoPurchaseValidator.validatePurchaseStringInput("5000");
    }
    @Test
    void 정상_금액_테스트() {
        LottoPurchaseValidator.validateAmount(3000);
    }

    @Test
    void 빈_문자열_테스트() {
        assertThatThrownBy(() -> LottoPurchaseValidator.validatePurchaseStringInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값은 비어있을 수 없습니다.");
    }

    @Test
    void 숫자_아님_테스트() {
        assertThatThrownBy(() -> LottoPurchaseValidator.validatePurchaseStringInput("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효한 숫자를 입력해야 합니다.");
    }
}
