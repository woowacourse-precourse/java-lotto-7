package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class InputViewTest extends NsTest {

    @Test
    void 구매금액_입력_정상입력() {
        run("8000");
        int purchaseAmount = InputView.inputPurchaseAmount();
        assertThat(purchaseAmount).isEqualTo(8000);
    }

    @Test
    void 구매금액_입력_비정상입력_예외발생() {
        run("abc");
        assertThatThrownBy(() -> {
            InputView.inputPurchaseAmount();
        }).isInstanceOf(NumberFormatException.class);
    }

    @Override
    protected void runMain() {

    }

}
