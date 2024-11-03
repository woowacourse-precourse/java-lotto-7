package lotto.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.PurchasePrice;
import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputServicePurchasePriceTest extends NsTest {
    private static final String INT_ERROR = "숫자가";
    private static final String EMPTY_ERROR = "비어있습니다";
    private final InputService InputService = new InputService(new InputView());
    private PurchasePrice purchasePrice;

    @Test
    void 구입_금액_숫자입력_성공() {
        assertSimpleTest(() -> {
            run("1000");
            Assertions.assertThat(purchasePrice.getPurchasePrice()).isEqualTo(1000);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", " 1000 "})
    void 구입_금액_int로_변환_실패_문자(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(INT_ERROR);
        });
    }

    @Test
    void 구입_금액_blank_실패() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(EMPTY_ERROR);
        });
    }

    @Test
    void 구입_금액_소수점_실패() {
        assertSimpleTest(() -> {
            runException("1000.4");
            assertThat(output()).contains(INT_ERROR);
        });
    }

    @Override
    protected void runMain() {
        purchasePrice = InputService.readPurchasePrice();
    }
}
