package lotto;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {
    @Test
    void 로또_생성_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> generatedLottos = lottoMachine.generateLottos(5);

        assertThat(generatedLottos).hasSize(5);
    }
}
