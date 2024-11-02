package lotto.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.constant.ExceptionMessage.INVALID_PRICE_CHAR;
import static lotto.constant.ExceptionMessage.INVALID_PRICE_MULTIPLE;
import static lotto.constant.ExceptionMessage.INVALID_PRICE_ZERO;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PurchasePriceValidatorTest extends NsTest {

    @Test
    @DisplayName("로또 구입 금액은 숫자 외의 문자를 포함할 수 없다.")
    void 로또_구입_금액_문자_종류_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("8000,"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_PRICE_CHAR.getMessage())
        );
    }

    @Test
    @DisplayName("로또 구입 금액은 로또 1개의 금액인 1000의 배수여야 한다.")
    void 로또_구입_금액_나머지_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("8001"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_PRICE_MULTIPLE.getMessage())
        );
    }

    @ParameterizedTest
    @CsvSource({"0", "00"})
    @DisplayName("로또 구입 금액은 0원 초과여야 한다.")
    void 로또_구입_금액_0원_예외_테스트(String price) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(price))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_PRICE_ZERO.getMessage())
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
