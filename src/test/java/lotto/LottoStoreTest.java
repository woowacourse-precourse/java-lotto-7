package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("구매 금액이 숫자가 아닐 때 예외가 발생한다.")
    @Test
    void 구매_금액이_숫자가_아닐_때_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("?");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구매 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void 구매_금액이_1000원_미만이면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구매 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구매_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구매 금액 만큼 로또를 구매한다.")
    @Test
    void 구매_금액_만큼_로또를_구매한다() {
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottoList = lottoStore.buyLotto(50000);
        assertThat(lottoList).hasSize(50);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}