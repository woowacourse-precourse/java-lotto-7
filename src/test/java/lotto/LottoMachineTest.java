package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {
    @Test
    void 로또_생성_테스트() {
        LottoMachine lottoMachine = new LottoMachine("5000");
        lottoMachine.generateLottos();

        assertThat(lottoMachine.getGeneratedLottos()).hasSize(5);
    }
}
