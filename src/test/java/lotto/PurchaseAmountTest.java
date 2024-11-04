package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountTest extends NsTest {

    @Test
    void 구매_금액을_입력하지_않은_경우_예외_발생() {
        assertThatThrownBy(() -> runException(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액을 입력해 주세요.");
    }

    @Test
    void 구매_금액이_1000원_단위가_아닌_경우_예외_발생() {
        assertThatThrownBy(() -> runException("2330"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해 주세요.");
    }

    @Test
    void 구매_금액이_int형_범위를_벗어날_경우_예외_발생() {
        assertThatThrownBy(() -> runException("388372749302"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 388372749302: 너무 큰 값을 입력하였습니다.");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
