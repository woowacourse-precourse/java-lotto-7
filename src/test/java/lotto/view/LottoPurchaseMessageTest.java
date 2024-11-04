package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.constants.errorType.LottoPurchaseErrorType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaseMessageTest extends NsTest {

    @Test
    @DisplayName("로또 구입 금액이 양수가 아닐경우 (음수, 0)테스트")
    void 로또_구입_금액_테스트() {
        assertSimpleTest(() -> {
            runException("-2000");
            assertThat(output()).contains(LottoPurchaseErrorType.INVALID_MONEY_NEGATIVE.getMessage());
        });
    }

    @Test
    @DisplayName("로또 구매 금액이 1000원 단위가 아닐 경우 테스트")
    void 천원_단위_금액_테스트() {
        assertSimpleTest(() -> {
            runException("1500");
            assertThat(output()).contains(LottoPurchaseErrorType.INVALID_MONEY_UNIT.getMessage());
        });
    }

    @Test
    @DisplayName("로또 구입 금액이 공백일 경우 테스트")
    void 로또_구입_금액_공백_테스트() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(LottoPurchaseErrorType.INVALID_INPUT_NULL_MONEY.getMessage());
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
