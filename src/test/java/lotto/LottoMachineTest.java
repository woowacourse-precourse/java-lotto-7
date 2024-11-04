package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    void 보너스_번호와_당첨_번호가_중복되면_예외() {
        Lotto winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThatThrownBy(() ->
                new LottoMachine(winningLotto, "5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호를_올바르게_입력하면_생성() {
        Lotto winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertDoesNotThrow(() -> new LottoMachine(winningLotto, "7"));
    }
}