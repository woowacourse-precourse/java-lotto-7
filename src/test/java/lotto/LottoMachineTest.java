package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @Test
    @DisplayName("로또를 발행한다")
    void publishLotto() {
        //given //when
        Lotto lotto = lottoMachine.publishLotto();
        List<Integer> numbers = lotto.getNumbers();

        //then
        assertThat(numbers).hasSize(6);
    }
}