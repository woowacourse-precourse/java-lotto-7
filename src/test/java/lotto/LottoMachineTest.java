package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @DisplayName("로또_머신은_주어진_수량만큼_로또를_발행할_수_있다")
    @Test
    public void issueLottoes() {
        //given
        int totalLottoCount = 4;

        //when
        List<Lotto> result = LottoMachine.issueLottoes(totalLottoCount);

        //then
        assertThat(result.size()).isEqualTo(totalLottoCount);
    }
}