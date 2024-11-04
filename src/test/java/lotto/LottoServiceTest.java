package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class LottoServiceTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private final LottoService lottoService = new LottoService();

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 구입_금액이_숫자가_아니면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1100");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구입_금액이_0_이하면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void parseCashToLottoAmount() {
    }

    @Test
    void parseWinningNumber() {
    }

    @Test
    void parseBonusNumber() {
    }

    @Test
    void getLotto() {
    }
}