package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
class LottoPurchaseTest extends NsTest {
    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_1000으로_나누어_떨어지지_않으면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("6500");
            assertThat(output()).contains(Constants.NOT_PRICE_UNIT);
        });
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}