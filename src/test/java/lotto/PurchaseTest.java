package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("금액을 잘 못 입력헸으면 예외가 발생한다.")
    @Test
    void 예외_테스트() {
        assertThatThrownBy(() -> new Purchase("1000j"))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("1000원 이하의 금액 예외 발생")
    @Test
    void mininumPrice() {
        assertThatThrownBy(() -> new Purchase("100").getLotoCount())
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Purchase("-1000").getLotoCount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
    }
}