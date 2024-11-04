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

    @Test
    void 당첨번호와_로또를_비교해_등수를_산출한다() {
        Lotto winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        LottoMachine lottoMachine = new LottoMachine(winningLotto, "7");

        Lotto firstLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto secondLotto = new Lotto(Arrays.asList(1,2,3,4,5,7));
        Lotto thirdLotto = new Lotto(Arrays.asList(1,2,3,4,5,8));
        Lotto fourthLotto = new Lotto(Arrays.asList(1,2,3,4,8,9));
        Lotto fiftyLotto = new Lotto(Arrays.asList(1,2,3,8,9,10));

        assertThat(lottoMachine.calculatePrice(firstLotto)).isEqualTo(Price.FIRST);
        assertThat(lottoMachine.calculatePrice(secondLotto)).isEqualTo(Price.SECOND);
        assertThat(lottoMachine.calculatePrice(thirdLotto)).isEqualTo(Price.THIRD);
        assertThat(lottoMachine.calculatePrice(fourthLotto)).isEqualTo(Price.FOURTH);
        assertThat(lottoMachine.calculatePrice(fiftyLotto)).isEqualTo(Price.FIFTH);
    }
}