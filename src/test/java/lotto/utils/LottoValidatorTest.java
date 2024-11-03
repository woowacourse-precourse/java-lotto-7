package lotto.utils;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoValidatorTest extends NsTest {

    private static final String ERROR_PREFIX = "[ERROR]";

    private final LottoValidator validator = new LottoValidator();

    @ParameterizedTest
    @ValueSource(strings = {"1.123", "1.0", "1.000"})
    @DisplayName("구매 금액의 유효성 검사시, 소수를 입력하면 예외가 발생한다")
    void t001(String purchaseAmount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.validatePurchaseAmount(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_PREFIX)
                        .hasMessageContaining("소수")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1000", "0"})
    @DisplayName("구매 금액의 유효성 검사시, 0이하의 값을 입력하면 예외가 발생한다")
    void t002(String purchaseAmount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.validatePurchaseAmount(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_PREFIX)
                        .hasMessageContaining("0 이하")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"\n", " ", ""})
    @DisplayName("구매 금액의 유효성 검사시, 공백을 입력하면 예외가 발생한다")
    void t003(String purchaseAmount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.validatePurchaseAmount(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_PREFIX)
                        .hasMessageContaining("공백")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "a", "zero"})
    @DisplayName("구매 금액의 유효성 검사시, 숫자가 아닌 값을 입력하면 예외가 발생한다")
    void t004(String purchaseAmount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.validatePurchaseAmount(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_PREFIX)
                        .hasMessageContaining("숫자")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "a", "zero"})
    @DisplayName("구매 금액의 유효성 검사시, 숫자가 아닌 값을 입력하면 예외가 발생한다")
    void t005(String purchaseAmount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.validatePurchaseAmount(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_PREFIX)
                        .hasMessageContaining("숫자")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1001", "1", "10001"})
    @DisplayName("구매 금액의 유효성 검사시, 1000원 단위가 아닌 값을 입력하면 예외가 발생한다")
    void t006(String purchaseAmount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.validatePurchaseAmount(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_PREFIX)
                        .hasMessageContaining("1000")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"+1000", "+10000", "+200000"})
    @DisplayName("구매 금액의 유효성 검사시, '+'가 붙은 값을 입력하면 예외가 발생한다")
    void t007(String purchaseAmount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.validatePurchaseAmount(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_PREFIX)
                        .hasMessageContaining("+")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {" 1000 ", "10000 ", " 200000"})
    @DisplayName("구매 금액의 유효성 검사시, 앞 뒤로 공백이 포함된 숫자를 입력하면 예외가 발생한다")
    void t008(String purchaseAmount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.validatePurchaseAmount(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_PREFIX)
                        .hasMessageContaining("공백")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}