package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.model.BonusNumber;
import lotto.model.LottoMachine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @Test
    void 정상_케이스() {
        LottoMachine lottoMachine = new LottoMachine(10000);
        Integer count = lottoMachine.getCount();
        assertEquals(lottoMachine.generateLotto().size(), 10);
        assertEquals(count, 10);
    }

    @Test
    @DisplayName("로또 구입 금액은 1000으로 나누어 떨어져야 한다.")
    void 구입_금액은_1000으로_나누어_떨어져야_한다() {
        assertThatThrownBy(() -> new LottoMachine(1110))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("로또 구입 금액은 항상 양수여야 한다.")
    void 구입_금액은_항상_양수여야_한다() {
        assertThatThrownBy(() -> new LottoMachine(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
