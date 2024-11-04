package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class LottoDispenserTest {

    @DisplayName("유효한 금액 입력 시 올바른 개수의 로또 발행")
    @Test
    void 유효한_금액_입력시_올바른_개수의_로또_발행() {
        LottoDispenser dispenser = new LottoDispenser();
        String inputMoney = "3000";

        LottoCollection lottoCollection = dispenser.executeTransactionAndDispense(inputMoney);

        assertThat(lottoCollection.getLottos()).hasSize(3);
    }

    @DisplayName("1,000원 단위가 아닌 금액 입력 시 예외 발생")
    @Test
    void 단위가_맞지_않는_금액_입력시_예외_발생() {
        LottoDispenser dispenser = new LottoDispenser();
        String inputMoney = "2500";

        assertThatThrownBy(() -> dispenser.executeTransactionAndDispense(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @DisplayName("숫자가 아닌 금액 입력 시 예외 발생")
    @Test
    void 숫자가_아닌_금액_입력시_예외_발생() {
        LottoDispenser dispenser = new LottoDispenser();
        String inputMoney = "abc";

        assertThatThrownBy(() -> dispenser.executeTransactionAndDispense(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 숫자만 입력 가능합니다.");
    }

    @DisplayName("음수 금액 입력 시 예외 발생")
    @Test
    void 음수_금액_입력시_예외_발생() {
        LottoDispenser dispenser = new LottoDispenser();
        String inputMoney = "-1000";

        assertThatThrownBy(() -> dispenser.executeTransactionAndDispense(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 양수여야 합니다.");
    }

    @DisplayName("0원 입력 시 예외 발생")
    @Test
    void 금액으로_0_입력시_예외_발생() {
        LottoDispenser dispenser = new LottoDispenser();
        String inputMoney = "0";

        assertThatThrownBy(() -> dispenser.executeTransactionAndDispense(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 양수여야 합니다.");
    }

    @DisplayName("빈 문자열 입력 시 예외 발생")
    @Test
    void 빈_문자열_입력시_예외_발생() {
        LottoDispenser dispenser = new LottoDispenser();
        String inputMoney = "";

        assertThatThrownBy(() -> dispenser.executeTransactionAndDispense(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액이 입력되지 않았습니다.");
    }

    @DisplayName("null 입력 시 예외 발생")
    @Test
    void null_입력시_예외_발생() {
        LottoDispenser dispenser = new LottoDispenser();
        String inputMoney = null;

        assertThatThrownBy(() -> dispenser.executeTransactionAndDispense(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액이 입력되지 않았습니다.");
    }
}
