package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest extends NsTest {
    private final InputView inputView = new InputView();

    @Test
    @DisplayName("구매금액 입력 메시지 출력 확인")
    void checkMessageFormat() {
        assertSimpleTest(() -> {
            inputView.displayPurchasePriceMessage();
            assertThat(output()).contains("구입금액을 입력해 주세요.");
        });
    }

    @Override
    protected void runMain() {
    }
}